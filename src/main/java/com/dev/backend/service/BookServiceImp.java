package com.dev.backend.service;

import java.util.Arrays;
import java.util.HashSet;

import com.dev.backend.repository.BookRepository;
import com.dev.backend.model.*;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BookServiceImp implements BookService {
    @Autowired
    BookRepository bookRepository;
    
    @Override
	public void saveAtCart(User user,Book book) {
		System.out.println(user.getEmail());
		System.out.println(book.getTitle());
		book.setCart((new HashSet<User>(Arrays.asList(user))));
		bookRepository.save(book);
		
	}
}