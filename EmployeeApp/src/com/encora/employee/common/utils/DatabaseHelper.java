package com.encora.employee.common.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

//Static method loads on initial of application
//Converting class to Singleton to reuse the object
public class DatabaseHelper {
	
	private static DatabaseHelper db = new DatabaseHelper();
	
	private DatabaseHelper() {}
	
	public static DatabaseHelper getInstance() {
		if(db == null) {
			db = new DatabaseHelper();
		}
		return db;
	}


	public Connection connectDB() {
		Connection connection = null;
		try {
			DriverManager.registerDriver(new Driver());
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3000/emp_db", "root", "root123");
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			return connection;
		}
	}

}
