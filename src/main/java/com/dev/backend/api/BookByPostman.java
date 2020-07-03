package com.dev.backend.api;

import com.dev.backend.model.Book;

import com.dev.backend.repository.BookRepository;

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
    private BookRepository bookRepository;
    //For Postman
    @PostMapping("/addBook")
    @ResponseBody
    public String addAll(@RequestBody List<Book> Books){
        bookRepository.saveAll(Books);
        return "person size:"+ Books.size();

    }
    @GetMapping("/postman/getBook")
    @ResponseBody
  public List<Book> getBook(){
      return (List<Book>) bookRepository.findAll();
  }
  @GetMapping(path="/postman/{id}")
  @ResponseBody
  public Optional<Book> getBookbyid(@PathVariable("id") int id){
    ArrayList<Book> result=new ArrayList<>();
    bookRepository.findById(id).ifPresent(result::add);
    
    return bookRepository.findById(id);
  }
  @DeleteMapping(path="/postman{id}")
  @ResponseBody
  public void deleteBookById(@PathVariable("id") int id){
      bookRepository.deleteById(id);
  }
  @PutMapping("/postman/put/{id}")
  @ResponseBody
  public void putBookById(@PathVariable("id") int id, @Valid @NonNull @RequestBody Book bookToUpdate) {
   
    
    bookToUpdate.setId(id);
    bookRepository.save(bookToUpdate);
  }
  
}
