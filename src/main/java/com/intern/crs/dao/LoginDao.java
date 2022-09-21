package com.intern.crs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.intern.crs.object.UserInfo;

public class LoginDao {
	
	public boolean validateLoginDetails(UserInfo userInfo) {
		DbConnection dbConnection = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String fetchquery = null;
		ResultSet rs = null;
		boolean status = false;
		
		try {
			fetchquery = "select * from users where email = ? and user_password=?";
			dbConnection = new DbConnection();
			connection = dbConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(fetchquery);
		
			preparedStatement.setString(1, userInfo.getEmail());
			preparedStatement.setString(2, userInfo.getPassword());
			
			rs = preparedStatement.executeQuery();
			status = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}

}
