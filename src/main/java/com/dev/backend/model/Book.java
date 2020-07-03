package com.dev.backend.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    private String isbn;
    private String title;
    private String author;
    private double price;
    private String category;
    private String img_name;
    private int quantity;
    @ManyToMany()
	@JoinTable(name = "user_cart", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> cart;

    public Book() {

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImg_name() {
        return img_name;
    }

    public void setImg_name(String img_name) {
        this.img_name = img_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }
    public String getAuthor() {
        return author;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCart() {
		
		String result="SITE_USER";
			return result;	
	}
	public void setCart(Set<User> cart) {
        
		this.cart.add(cart.iterator().next());
     
	}
 }