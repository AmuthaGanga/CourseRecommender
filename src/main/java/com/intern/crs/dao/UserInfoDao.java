package com.intern.crs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.intern.crs.object.CourseInfo;
import com.intern.crs.object.UserInfo;

public class UserInfoDao {
	
	public UserInfo getUserByUserName(String userName) {
		DbConnection dbConnection = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		UserInfo userInfo = null;
		String fetchquery = null;
		ResultSet rs = null;
		
		try {
			fetchquery = "select * from users where email = ?";
			dbConnection = new DbConnection();
			connection = dbConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(fetchquery);
		
			preparedStatement.setString(1, userName);
			
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				if(userInfo == null) {
					userInfo = new UserInfo();
				}
				userInfo.setUserId(rs.getInt(1));
				userInfo.setFirstName(rs.getString(2));
				userInfo.setLastName(rs.getString(3));
				userInfo.setEmail(rs.getString(7));
				userInfo.setPassword(rs.getString(9));
				userInfo.setUserRole(rs.getString(10));
			}
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userInfo;
	}
	
	public int createNewUser(UserInfo userInfo) {
		DbConnection dbConnection = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertQuery = null;
		int rowsInserted = 0;
		
		try {
			insertQuery = "Insert into users (first_name, last_name, date_of_birth, gender, phone_number, email, address, user_password, user_role)\r\n"
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			dbConnection = new DbConnection();
			connection = dbConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(insertQuery);
		
			preparedStatement.setString(1, userInfo.getFirstName());
			preparedStatement.setString(2, userInfo.getLastName());
			preparedStatement.setDate(3, (Date)userInfo.getDob());
			preparedStatement.setString(4, userInfo.getGender());
			preparedStatement.setString(5, userInfo.getPhone_number());
			preparedStatement.setString(6, userInfo.getEmail());
			preparedStatement.setString(7, userInfo.getAddress());
			preparedStatement.setString(8, userInfo.getPassword());
			preparedStatement.setString(9, "student");
			
			rowsInserted = preparedStatement.executeUpdate();
			
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsInserted;
	}
	
	public List<UserInfo> fetchAllUsers(){
		List<UserInfo> usersList = null;
		DbConnection dbConnection = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		UserInfo userInfo = null;
		String fetchquery = null;
		ResultSet rs = null;
		
		try {
			fetchquery = "select * from users";
			dbConnection = new DbConnection();
			connection = dbConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(fetchquery);
			
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				userInfo = new UserInfo();
				if(usersList == null) {
					usersList = new ArrayList<UserInfo>();
				}
				userInfo.setUserId(rs.getInt(1));
				userInfo.setFirstName(rs.getString(2));
				userInfo.setLastName(rs.getString(3));
				userInfo.setDob(rs.getDate(4));
				userInfo.setGender(rs.getString(5));
				userInfo.setPhone_number(rs.getString(6));
				userInfo.setEmail(rs.getString(7));
				userInfo.setAddress(rs.getString(8));
				usersList.add(userInfo);
			}
			
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usersList;
	}
	
	public int updateUserPassword(String email, String password) {
		DbConnection dbConnection = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String updateQuery = null;
		int rowsUpdated = 0;
		
		try {
			updateQuery = "Update users set user_password = ? where email = ?";
			dbConnection = new DbConnection();
			connection = dbConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(updateQuery);
		
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, email);
			
			rowsUpdated = preparedStatement.executeUpdate();
			
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsUpdated;
	}

}
