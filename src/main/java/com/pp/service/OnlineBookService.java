package com.pp.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pp.dao.BookDAO;


@Service
public class OnlineBookService implements BookService {
	
	@Autowired
	BookDAO dao;

	@Override
	public Book createBook(Book book) throws SQLException {
		// TODO Auto-generated method stub
		
		return dao.insertBook(book);
		
	}

	 public List<Book> getAllBooks()
     {
         return dao.getAllBooks();
     }
	

}
