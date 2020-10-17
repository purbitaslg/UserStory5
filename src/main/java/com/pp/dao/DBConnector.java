package com.pp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	static DBConnector db;
	
	public DBConnector() {
		
		super();
		
		try {
			Class.forName("com.mysql.jdbc.driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
public static DBConnector getInstance() {
		
		if(db==null)
		db=new DBConnector();
		return db;
	}
	
	public static Connection getConnection() throws SQLException {
		return (DriverManager.getConnection("jdbc:mysql://localhost:3306/schemaone","root","Admindxc"));
	}

}
