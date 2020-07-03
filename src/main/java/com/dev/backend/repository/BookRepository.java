package com.dev.backend.repository;

import java.util.List;

import com.dev.backend.model.Book;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Integer> {

    

    @Query(value="select c from Book c where c.title like %:keyword% or c.author like %:keyword% or c.category like %:keyword%")
    public List<Book> searchByBook(@Param("keyword") String keyword);
    @Query(value="select c.img_name from Book c  ")
    public List<String> getImg();
    @Query(value="select c.title from Book c  ")
    public List<String> getTitle();
    @Query(value="select c from Book c where c.img_name like %:keyword% ")
    public Book searchByImage(@Param("keyword") String keyword);
    @Query(value="select c from Book c where c.isbn like %:keyword%")
    public List<Book> searchByIsbn(@Param("keyword") String keyword);
    @Query(value="select c from Book c where c.title like %:keyword%")
    public List<Book> searchByTitle(@Param("keyword") String keyword);
    @Query(value="select c from Book c where c.category like %:keyword%")
    public List<Book> searchByCategory(@Param("keyword") String keyword);
    @Query(value="select c from Book c where c.author like %:keyword%")
    public List<Book> searchByAuthor(@Param("keyword") String keyword);
    @Query(value="select c from Book c inner join c.cart t on t.id=?1")
    public List<Book> findBookInCart(int keyword);
} 