package com.intern.crs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class DbConnection {

	public static void main(String[] args) {
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.getDBConnection();
		System.out.println(connection.toString());
		System.out.println(new Date());
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public Connection getDBConnection() {
		
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/recommender", "root", "Amu@Optisol123");
		} catch (ClassNotFoundException e) {
			System.out.println("In DbConnection class...");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("In DbConnection class...");
			e.printStackTrace();
		}
		
		
		return connection;
	}

}
