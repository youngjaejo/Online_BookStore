# prerequisite
 - Spring Boot 2.3.1
    - Spring Boot DevTools
    - MySql Drive
    - Spring Web
    - Thymeleaf
    - Spring security
    - Spring Data JPA
    - HTML5
    - CSS
 - Mysql
 - VS Code

# Online BookStore
This is an online bookstore created using the java spring boot framework, created using MVC, Mysql, hibernate, and spring security. The application has two major modes. One is admin user mode and the other is client user. This admin and client can be distinguished by logging in through Spring Security. When an admin user adds a book to the admin side, data is stored in Mysql through Hibernate and the book information is viewed from the user side.the app is Enhanced E2E security by integrating authentication through Spring
Security.

URLs
 - localhost:8080/main/login
 - localhost:8080/logout
   - Admin Side
   - localhost:8080/main/mainpage
     - localhost:8080/main/book
     - localhost:8080/main/customer
       - localhost:8080/main/AdminUserRegester
       - localhost:8080/main/webUserRegester_main
       - localhost:8080/main/searchByemail?keyword= //from use input
       - localhost:8080/main/searchByFName?keyword= //from use input
       - localhost:8080/main/searchByLName?keyword= //from use input
       - localhost:8080/main/searchByRole?keyword= //from use input
       - localhost:8080/editUser/{user_id}
       - localhost:8080/deleteUser/{user_id}
     - localhost:8080/main/book
       - localhost:8080/main/addNewBook
       - localhost:8080/main/searchByIsbn?keyword= //from use input
       - localhost:8080/main/searchByAuthor?keyword= //from use input
       - localhost:8080/main/searchByTitle?keyword= //from use input
       - localhost:8080/main/searchByCategory?keyword= //from use input
       - localhost:8080/editBook/{book_id}
       - localhost:8080/deletBook/{book_id}
   - Customer Side
   - localhost:8080/webHome/webMain
     - localhost:8080/webHome/{img_name} 
     - localhost:8080/webHome/webMain
     - localhost:8080/webHome/cart
     - localhost:8080/webHome/cart/{book_id}
# Model View Contrl(MVC) 
  - Models\
     ![model](https://user-images.githubusercontent.com/44520516/86445586-825f0300-bcc7-11ea-91ed-17d28634c3ee.jpg)
  - Repositories\
     ![repositories](https://user-images.githubusercontent.com/44520516/86446150-63ad3c00-bcc8-11ea-9277-7c83a77d47b3.jpg)
  - Services\
     ![service](https://user-images.githubusercontent.com/44520516/86446220-83446480-bcc8-11ea-97ae-386fbf1a64db.jpg)
  - View\
     ![view](https://user-images.githubusercontent.com/44520516/86447663-88a2ae80-bcca-11ea-88d3-e613bd8575d5.jpg)

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
 the Query to search type of roles through joined table.
 ```java
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value="select c from User c inner join c.roles r on r.role like %:keyword%")
    public List<User> findByRoles(@Param("keyword") String keyword);
     }
 ```
 the Query to search books in cart.
  ```java
@Repository
public interface BookDao extends JpaRepository<Book, Integer> {
    @Query(value="select c from Book c inner join c.cart t on t.id=?1")
    public List<Book> findBookInCart(int keyword);
} 
 ```
![RDBMS Diagram](https://user-images.githubusercontent.com/44520516/85910272-c38c7a00-b7d2-11ea-96a0-95b641d56caa.png)


 <!--- # Spring Boot Security
 
  ```properties
  	
  ``` --->
