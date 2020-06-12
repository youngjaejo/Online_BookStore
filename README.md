# prerequisite
 - Spring Boot 2.3.1
    - Spring Boot DevTools
    - MySql Drive
    - Spring Web
    - Thymeleaf
    - Spring security
    - Spring Data JPA
 - Mysql
 - VS Code
# Online BookStore
This is an online bookstore created using the java spring boot framework, created using MVC, Mysql, hibernate, and spring security. The application has two major modes. One is admin user mode and the other is client user. This admin and client can be distinguished by logging in through Spring Security. 

- localhost:8080/main/login
- Admin Side
  - localhost:8080/main/mainpage
    - localhost:8080/main/book
    - localhost:8080/main/customer
 - Customer Side
   - localhost:8080/webHome/webMain
     - localhost:8080/webHome/{img_name} 
     - localhost:8080/webHome/newC_web
 When an admin user adds a book to the admin side, data is stored in Mysql through Hibernate and the book information is viewed from the user side.

