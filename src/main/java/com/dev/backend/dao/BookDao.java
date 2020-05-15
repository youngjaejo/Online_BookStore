package com.dev.backend.dao;

import java.util.List;

import com.dev.backend.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookDao extends JpaRepository<Book, Integer> {

    

    @Query(value="select c from Book c where c.title like %:keyword% or c.author like %:keyword% or c.category like %:keyword%")
    public List<Book> search(@Param("keyword") String keyword);
    @Query(value="select c.img_name from Book c ")
    public List<String> getImg();
    @Query(value="select c from Book c where c.img_name like %:keyword% ")
    public List<Book> searchByImage(@Param("keyword") String keyword);
} 