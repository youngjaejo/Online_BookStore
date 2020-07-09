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
 - AWS 
  - Elest
  - RDS(Mysql)
 - VS Code

# Online BookStore
This is an online bookstore created using the java spring boot framework, created using MVC, Mysql, hibernate, and spring security. The application has two major modes. One is admin user mode and the other is client user. This admin and client can be distinguished by logging in through Spring Security. When an admin user adds a book to the admin side, data is stored in Mysql through Hibernate and the book information is viewed from the user side.the app is Enhanced E2E security by integrating authentication through Spring
Security.

![RDBMS Diagram](https://user-images.githubusercontent.com/44520516/85910272-c38c7a00-b7d2-11ea-96a0-95b641d56caa.png)

URLs
 - http://book-env.eba-bq9p8mb5.us-west-1.elasticbeanstalk.com/main/login
 - http://book-env.eba-bq9p8mb5.us-west-1.elasticbeanstalk.com/logout
   
   - Admin Side
   - http://book-env.eba-bq9p8mb5.us-west-1.elasticbeanstalk.com/main/mainpage
     - http://book-env.eba-bq9p8mb5.us-west-1.elasticbeanstalk.com/main/customer
       - http://book-env.eba-bq9p8mb5.us-west-1.elasticbeanstalk.com/main/AdminUserRegester
       - http://book-env.eba-bq9p8mb5.us-west-1.elasticbeanstalk.com/webUserRegester_main
       - http://book-env.eba-bq9p8mb5.us-west-1.elasticbeanstalk.com/main/searchByemail?keyword= //from use input
       - http://book-env.eba-bq9p8mb5.us-west-1.elasticbeanstalk.com/main/searchByFName?keyword= //from use input
       - http://book-env.eba-bq9p8mb5.us-west-1.elasticbeanstalk.com/main/searchByLName?keyword= //from use input
       - http://book-env.eba-bq9p8mb5.us-west-1.elasticbeanstalk.com/main/searchByRole?keyword= //from use input
       - http://book-env.eba-bq9p8mb5.us-west-1.elasticbeanstalk.com/editUser/{user_id}
       - http://book-env.eba-bq9p8mb5.us-west-1.elasticbeanstalk.com/deleteUser/{user_id}
     - http://book-env.eba-bq9p8mb5.us-west-1.elasticbeanstalk.com/main/book
       - http://book-env.eba-bq9p8mb5.us-west-1.elasticbeanstalk.com/main/addNewBook
       - http://book-env.eba-bq9p8mb5.us-west-1.elasticbeanstalk.com/searchByIsbn?keyword= //from use input
       - http://book-env.eba-bq9p8mb5.us-west-1.elasticbeanstalk.com/searchByAuthor?keyword= //from use input
       - http://book-env.eba-bq9p8mb5.us-west-1.elasticbeanstalk.com/searchByTitle?keyword= //from use input
       - http://book-env.eba-bq9p8mb5.us-west-1.elasticbeanstalk.com/main/searchByCategory?keyword= //from use input
       - http://book-env.eba-bq9p8mb5.us-west-1.elasticbeanstalk.com/editBook/{book_id}
       - http://book-env.eba-bq9p8mb5.us-west-1.elasticbeanstalk.com/deletBook/{book_id}
   - Customer Side
     - http://book-env.eba-bq9p8mb5.us-west-1.elasticbeanstalk.com/webHome/webMain
     - http://book-env.eba-bq9p8mb5.us-west-1.elasticbeanstalk.com/webHome/{img_name} 
     - http://book-env.eba-bq9p8mb5.us-west-1.elasticbeanstalk.com/webHome/webMain
     - http://book-env.eba-bq9p8mb5.us-west-1.elasticbeanstalk.com/webHome/cart
     - http://book-env.eba-bq9p8mb5.us-west-1.elasticbeanstalk.com/webHome/cart/{book_id}
#Properties
  ```properties
  
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
server.port=5000
spring.datasource.url=jdbc:mysql://${RDS_HOSTNAME}:${RDS_PORT}/${RDS_DB_NAME} 
spring.datasource.username=${RDS_USERNAME}
spring.datasource.password=${RDS_PASSWORD}
spring.jpa.hibernate.ddl-auto=none

#connecttion with S3
s3.endpointUrl=s3-website-us-west-1.amazonaws.com
s3.accessKey=??????
s3.secertKey=??????
s3.bucketName=?????/image

#Spring Security login queries
security.basic.enabled=false
spring.queries.users-query=select email, password, '1' as enabled from auth_user where email=? and status='VERIFIED'
spring.queries.roles-query=select u.email, r.role_name from auth_user u inner join auth_user_role ur on(u.auth_user_id=ur.auth_user_id) inner join auth_role r on(ur.auth_role_id=r.auth_role_id) where u.email=?
spring.queries.users_inner_roles-query=select u.email, r.role_name from auth_user u inner join auth_user_r cd	
  ``` 

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
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value="select c from Book c inner join c.cart t on t.id=?1")
    public List<Book> findBookInCart(int keyword);
} 
 ```




