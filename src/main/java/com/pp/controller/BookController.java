package com.pp.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.pp.service.Book;
import com.pp.service.BookService;
import com.pp.service.OnlineBookService;

@RestController
@RequestMapping(value="/web")
public class BookController {
	
	@Autowired
	BookService service;
	
	@Autowired
    OnlineBookService user;
	
	@RequestMapping(value="/book")
	public Book insertBook(Book book) throws SQLException {
		
		System.out.println("hello");
		return service.createBook(book);
	}

	@RequestMapping(value="/booklist")
    public List<Book> getBooks()
    {
        return user.getAllBooks();
    }

}
