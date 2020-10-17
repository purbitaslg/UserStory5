package com.pp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.pp.service.Book;

@Repository
public class BookDAO {
	
	 List<Book> books;
	 Connection con;
	

	public BookDAO() {
		super();
		
		// TODO Auto-generated constructor stub
		
		books=new ArrayList<Book>();
        books.add(new Book(1,"Like It Happened Yesterday","Biopic",600.00));
        books.add(new Book(2,"Last Breath","Horror",400.00));
        books.add(new Book(3,"Notebook","Romantic",300.00));
        
	}

	//Please enter different id every time while running the program as id is the primary key
	
	public  Book insertBook(Book book) throws SQLException {
		
		try{
			//Book book= new Book();
			con=DBConnector.getConnection();
		
			String query=("insert into springbook values(?,?,?,?)");
			PreparedStatement ps = con.prepareStatement(query);
		
		  ps.setInt(1,6); 
		  ps.setString(2,"DBMS"); 
		  ps.setString(3,"efg");
		  ps.setDouble(4,800.00);
		  ps.executeUpdate();
		  PreparedStatement ps1=con.prepareStatement("select * from springbook");
		  ResultSet rs=ps1.executeQuery();
		  while(rs.next())
			 {
				 System.out.println("Book id is "+rs.getInt(1)+" Book title is "+rs.getString(2)+" Author of the book is "+rs.getString(3)+" Price of the book is "+rs.getDouble(4));
			 }
		  
		  return book;
		  
		} /*
			 * catch(Exception e){ e.printStackTrace(); return null; }
			 */
		
		finally {
			
			con.close();
			
		}
		//return null;
}
	
	public List<Book> getAllBooks() 
    {
            
        return books;
        
    }
	
	
	
	
}
