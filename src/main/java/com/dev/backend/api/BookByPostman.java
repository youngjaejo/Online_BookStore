package com.dev.backend.api;

import com.dev.backend.model.Book;

import com.dev.backend.dao.BookDao;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import lombok.NonNull;

import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class BookByPostman{

    @Autowired
    private BookDao dao;
    //For Postman
    @PostMapping("/addBook")
    @ResponseBody
    public String addAll(@RequestBody List<Book> Books){
        dao.saveAll(Books);
        return "person size:"+ Books.size();

    }
    @GetMapping("/getBook")
    @ResponseBody
  public List<Book> getBook(){
      return (List<Book>) dao.findAll();
  }
  @GetMapping(path="{id}")
  @ResponseBody
  public Optional<Book> getBookbyid(@PathVariable("id") int id){
    ArrayList<Book> result=new ArrayList<>();
    dao.findById(id).ifPresent(result::add);
    
    return dao.findById(id);
  }
  @DeleteMapping(path="{id}")
  @ResponseBody
  public void deleteBookById(@PathVariable("id") int id){
      dao.deleteById(id);
  }
  @PutMapping("/put/{id}")
  @ResponseBody
  public void putBookById(@PathVariable("id") int id, @Valid @NonNull @RequestBody Book bookToUpdate) {
   
    
    bookToUpdate.setId(id);
    dao.save(bookToUpdate);
  }
  
}
