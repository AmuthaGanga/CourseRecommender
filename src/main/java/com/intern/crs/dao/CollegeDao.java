package com.intern.crs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.intern.crs.object.CollegeInfo;

public class CollegeDao {
	
	/**
	 * Method to insert a new row in the Colleges table
	 * 
	 * @param collegeInfo
	 * @return
	 */
	public int createNewCollege(CollegeInfo collegeInfo) {
		DbConnection dbConnection = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertQuery = null;
		int collegeId = 0;
		ResultSet rs = null;
		
		try {
			insertQuery = "Insert into colleges (college_name, city, university, website, accreditated_by, naac_score)\r\n"
					+ "values (?, ?, ?, ?, ?, ?)";
			dbConnection = new DbConnection();
			connection = dbConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
		
			preparedStatement.setString(1, collegeInfo.getCollegeName());
			preparedStatement.setString(2, collegeInfo.getCity());
			preparedStatement.setString(3, collegeInfo.getUniversity());
			preparedStatement.setString(4, collegeInfo.getWebsite());
			preparedStatement.setString(5, collegeInfo.getAccreditatedBy());
			preparedStatement.setString(6, collegeInfo.getNaacScore());

			
			preparedStatement.executeUpdate();
			
			rs = preparedStatement.getGeneratedKeys();
			while(rs.next()) {
				collegeId = rs.getInt(1);
			}
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return collegeId;
	}
	
	/**
	 * Method to update an existing row in colleges table
	 * @param collegeInfo
	 * @return
	 */
	public int updateCollegeInfo(CollegeInfo collegeInfo) {
		DbConnection dbConnection = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String updateQuery = null;
		int rowsUpdated = 0;
		
		try {
			updateQuery = "Update colleges set college_name = ?, city = ?, university = ?, website = ?, accreditated_by = ?, naac_score = ? where college_id = ?";
			dbConnection = new DbConnection();
			connection = dbConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(updateQuery);
		
			preparedStatement.setString(1, collegeInfo.getCollegeName());
			preparedStatement.setString(2, collegeInfo.getCity());
			preparedStatement.setString(3, collegeInfo.getUniversity());
			preparedStatement.setString(4, collegeInfo.getWebsite());
			preparedStatement.setString(5, collegeInfo.getAccreditatedBy());
			preparedStatement.setString(6, collegeInfo.getNaacScore());
			preparedStatement.setInt(7, collegeInfo.getCollegeId());

			
			rowsUpdated = preparedStatement.executeUpdate();
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsUpdated;
	}
	
	/**
	 * Method to delete an existing row in colleges table
	 * @param collegeInfo
	 * @return
	 */
	public int deleteCollegeInfo(int collegeId) {
		DbConnection dbConnection = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String deleteQuery = null;
		int rowsDeleted = 0;
		
		try {
			deleteQuery = "Delete from colleges where college_id = ?";
			dbConnection = new DbConnection();
			connection = dbConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(deleteQuery);
		
			preparedStatement.setInt(1, collegeId);
			
			rowsDeleted = preparedStatement.executeUpdate();
			
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsDeleted;
	}
	
	
	/**
	 * Method to fetch all the existing records in the college table
	 * @return
	 */
	public List<CollegeInfo> fetchAllColleges(){
		List<CollegeInfo> collegesList = null;
		DbConnection dbConnection = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		CollegeInfo collegeInfo = null;
		String fetchquery = null;
		ResultSet rs = null;
		
		try {
			fetchquery = "select * from colleges";
			dbConnection = new DbConnection();
			connection = dbConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(fetchquery);
			
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				collegeInfo = new CollegeInfo();
				if(collegesList == null) {
					collegesList = new ArrayList<CollegeInfo>();
				}
				collegeInfo.setCollegeId(rs.getInt(1));
				collegeInfo.setCollegeName(rs.getString(2));
				collegeInfo.setCity(rs.getString(3));
				collegeInfo.setUniversity(rs.getString(4));
				collegeInfo.setWebsite(rs.getString(5));
				collegeInfo.setAccreditatedBy(rs.getString(6));
				collegeInfo.setNaacScore(rs.getString(7));
				collegesList.add(collegeInfo);
			}
			
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return collegesList;
	}
	
	/**
	 * Method to fetch a college based on ID
	 * @return
	 */
	public CollegeInfo fetchCollegeById(int collegeId){
		DbConnection dbConnection = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		CollegeInfo collegeInfo = null;
		String fetchquery = null;
		ResultSet rs = null;
		
		try {
			fetchquery = "select * from colleges where college_id = ?";
			dbConnection = new DbConnection();
			connection = dbConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(fetchquery);
			
			preparedStatement.setInt(1, collegeId);
			
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				collegeInfo = new CollegeInfo();
				collegeInfo.setCollegeId(rs.getInt(1));
				collegeInfo.setCollegeName(rs.getString(2));
				collegeInfo.setCity(rs.getString(3));
				collegeInfo.setUniversity(rs.getString(4));
				collegeInfo.setWebsite(rs.getString(5));
				collegeInfo.setAccreditatedBy(rs.getString(6));
				collegeInfo.setNaacScore(rs.getString(7));
			}
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return collegeInfo;
	}
	
	/**
	 * Method to fetch a college based on ID with courses list populated
	 * @return
	 */
	public CollegeInfo fetchCollegeByIdWithCoursesList(int collegeId){
		DbConnection dbConnection = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		CollegeInfo collegeInfo = null;
		String fetchquery = null;
		ResultSet rs = null;
		
		try {
			fetchquery = "select * from colleges where college_id = ?";
			dbConnection = new DbConnection();
			connection = dbConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(fetchquery);
			
			preparedStatement.setInt(1, collegeId);
			
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				collegeInfo = new CollegeInfo();
				collegeInfo.setCollegeId(rs.getInt(1));
				collegeInfo.setCollegeName(rs.getString(2));
				collegeInfo.setCity(rs.getString(3));
				collegeInfo.setUniversity(rs.getString(4));
				collegeInfo.setWebsite(rs.getString(5));
				collegeInfo.setAccreditatedBy(rs.getString(6));
				collegeInfo.setNaacScore(rs.getString(7));
			}
			
			CourseDao courseDao = new CourseDao();
			collegeInfo.setCoursesList(courseDao.fetchCoursesByCollegeId(collegeId));
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return collegeInfo;
	}
	
	/**
	 * Method to create mapping entries between colleges and courses
	 * @param collegeId
	 * @param courseId
	 */
	public void createCollegeCourseMap(int collegeId, int courseId) {
		DbConnection dbConnection = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertQuery = null;
		
		try {
			insertQuery = "Insert into colleges_courses_map (college_id, course_id) values (?, ?)";
			dbConnection = new DbConnection();
			connection = dbConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(insertQuery);
		
			preparedStatement.setInt(1, collegeId);
			preparedStatement.setInt(2, courseId);

			preparedStatement.executeUpdate();
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to fetch list of colleges based on the course id from mappings table
	 * @param courseId
	 * @return
	 */
	public List<CollegeInfo> fetchCollegesByCourseId(int courseId){
		List<CollegeInfo> collegesList = null;
		DbConnection dbConnection = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		CollegeInfo collegeInfo = null;
		String fetchquery = null;
		ResultSet rs = null;
		
		try {
			fetchquery = "select distinct c.* from colleges c,colleges_courses_map ccm where c.college_id = ccm.college_id and ccm.course_id = ?";
			dbConnection = new DbConnection();
			connection = dbConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(fetchquery);
			
			preparedStatement.setInt(1, courseId);
			
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				collegeInfo = new CollegeInfo();
				if(collegesList == null) {
					collegesList = new ArrayList<CollegeInfo>();
				}
				collegeInfo.setCollegeId(rs.getInt(1));
				collegeInfo.setCollegeName(rs.getString(2));
				collegeInfo.setCity(rs.getString(3));
				collegeInfo.setUniversity(rs.getString(4));
				collegeInfo.setWebsite(rs.getString(5));
				collegeInfo.setAccreditatedBy(rs.getString(6));
				collegeInfo.setNaacScore(rs.getString(7));
				collegesList.add(collegeInfo);
			}
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return collegesList;
	}
	
	/**
	 * Method to delete mappings of a college
	 * @param collegeId
	 */
	public void deleteMappingsByCollegeId(int collegeId) {
		DbConnection dbConnection = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String deleteQuery = null;
		
		try {
			deleteQuery = "Delete from colleges_courses_map where college_id = ?";
			dbConnection = new DbConnection();
			connection = dbConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(deleteQuery);
		
			preparedStatement.setInt(1, collegeId);
			
			preparedStatement.executeUpdate();
			
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to fetch a colleges information based on the college name
	 * @param collegeName
	 * @return
	 */
	public CollegeInfo fetchCollegeByName(String collegeName){
		DbConnection dbConnection = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		CollegeInfo collegeInfo = null;
		String fetchquery = null;
		ResultSet rs = null;
		
		try {
			fetchquery = "select * from colleges where college_name = ?";
			dbConnection = new DbConnection();
			connection = dbConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(fetchquery);
			
			preparedStatement.setString(1, collegeName);
			
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				collegeInfo = new CollegeInfo();
				collegeInfo.setCollegeId(rs.getInt(1));
				collegeInfo.setCollegeName(rs.getString(2));
				collegeInfo.setCity(rs.getString(3));
				collegeInfo.setUniversity(rs.getString(4));
				collegeInfo.setWebsite(rs.getString(5));
				collegeInfo.setAccreditatedBy(rs.getString(6));
				collegeInfo.setNaacScore(rs.getString(7));
			}
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return collegeInfo;
	}
	

}
