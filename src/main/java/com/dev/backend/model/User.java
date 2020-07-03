package com.dev.backend.model;

import java.util.Iterator;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "auth_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auth_user_id")
	private int id;

	@NotNull(message="First name is Empty")
	@Column(name = "first_name")
	private String firstName;

	@NotNull(message="Last name is Empty")
	@Column(name = "last_name")
	private String lastName;

	@NotNull(message="Email is Empty")
	@Email(message = "Email is invalid")
	@Column(name = "email")
	private String email;

	@NotNull(message="Password is Empty")
	@Length(min=5, message="Password should be at least 5 characters")
	@Column(name = "password")
	private String password;


	@Column(name = "status")
	private String status;
	@OneToMany()
	@JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name = "auth_user_id"), inverseJoinColumns = @JoinColumn(name = "auth_role_id"))
	private Set<Role> roles;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getRoles() {
		
		String result="SITEUSER";
	
		Iterator<Role> role=roles.iterator();
			while(role.hasNext()){
				Role x=role.next();
			
				
				if((x.getRole()).compareTo("SUPER_USER") == 0)
				{result="SUPER USER";
					break;}
				else if((x.getRole()).compareTo("ADMIN_USER")==0)
				{result= "ADMIN USER";}
				System.out.println(1);
		
				


			}
			return result;
	}
	

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
		System.out.println(roles);
	}

}
