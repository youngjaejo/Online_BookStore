# prerequisite
 - Spring Boot 2.3.1
    - Spring Boot DevTools
    - MySql Drive
    - Spring Web
    - Thymeleaf
    - Spring security
    - Spring Data JPA
    - CSS
 - Mysql
 - VS Code

# Online BookStore
This is an online bookstore created using the java spring boot framework, created using MVC, Mysql, hibernate, and spring security. The application has two major modes. One is admin user mode and the other is client user. This admin and client can be distinguished by logging in through Spring Security. When an admin user adds a book to the admin side, data is stored in Mysql through Hibernate and the book information is viewed from the user side.the app is Enhanced E2E security by integrating authentication through Spring
Security.

 - localhost:8080/main/login
   - Admin Side
   - localhost:8080/main/mainpage
     - localhost:8080/main/book
     - localhost:8080/main/customer
   - Customer Side
   - localhost:8080/webHome/webMain
     - localhost:8080/webHome/{img_name} 
     - localhost:8080/webHome/newC_web
     - localhost:8080/webHome/cart
     - localhost:8080/webHome/cart/{book_id}
  
  # Reletional Database
 Decleared joined tanble on backend server
 ```java
 @OneToMany()
	@JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name = "auth_user_id"), inverseJoinColumns = @JoinColumn(name = "auth_role_id"))
	private Set<Role> roles;
 
 @ManyToMany()
	@JoinTable(name = "user_cart", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> cart;

 ```
![RDBMS Diagram](https://user-images.githubusercontent.com/44520516/85910272-c38c7a00-b7d2-11ea-96a0-95b641d56caa.png)



