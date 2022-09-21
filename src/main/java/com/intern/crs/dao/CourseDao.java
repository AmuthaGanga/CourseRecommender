package com.intern.crs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.intern.crs.object.CourseInfo;

public class CourseDao {
	
	/**
	 * Method to create a new row in Courses table
	 * @param courseInfo
	 * @return
	 */
	public int createNewCourse(CourseInfo courseInfo) {
		DbConnection dbConnection = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertQuery = null;
		int rowsInserted = 0;
		
		try {
			insertQuery = "Insert into courses (course_name, duration, eligibility, placement_opportunities) values (?, ?, ?, ?)";
			dbConnection = new DbConnection();
			connection = dbConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(insertQuery);
		
			preparedStatement.setString(1, courseInfo.getCourseName());
			preparedStatement.setString(2, courseInfo.getDuration());
			preparedStatement.setString(3, courseInfo.getEligibility());
			preparedStatement.setString(4, courseInfo.getPlacementOpportunities());
			
			rowsInserted = preparedStatement.executeUpdate();
			
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsInserted;
	}
	
	/**
	 * Method to update a row in Courses table
	 * @param courseInfo
	 * @return
	 */
	public int updateCourseInfo(CourseInfo courseInfo) {
		DbConnection dbConnection = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String updateQuery = null;
		int rowsUpdated = 0;
		
		try {
			updateQuery = "Update courses set course_name = ?, duration = ?, eligibility = ?, placement_opportunities = ? where course_id = ?";
			dbConnection = new DbConnection();
			connection = dbConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(updateQuery);
		
			preparedStatement.setString(1, courseInfo.getCourseName());
			preparedStatement.setString(2, courseInfo.getDuration());
			preparedStatement.setString(3, courseInfo.getEligibility());
			preparedStatement.setString(4, courseInfo.getPlacementOpportunities());
			preparedStatement.setInt(5, courseInfo.getCourseId());

			
			rowsUpdated = preparedStatement.executeUpdate();
			
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsUpdated;
	}
	
	/**
	 * Method to delete a record from Courses table
	 * @param courseId
	 * @return
	 */
	public int deleteCourseInfo(int courseId) {
		DbConnection dbConnection = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String deleteQuery = null;
		int rowsDeleted = 0;
		
		try {
			deleteQuery = "Delete from courses where course_id = ?";
			dbConnection = new DbConnection();
			connection = dbConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(deleteQuery);
		
			preparedStatement.setInt(1, courseId);
			
			rowsDeleted = preparedStatement.executeUpdate();
			
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsDeleted;
	}
	
	/**
	 * Method to fetch all the available records from courses table
	 * @return
	 */
	public List<CourseInfo> fetchAllCourses(){
		List<CourseInfo> coursesList = null;
		DbConnection dbConnection = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		CourseInfo courseInfo = null;
		String fetchquery = null;
		ResultSet rs = null;
		
		try {
			fetchquery = "select * from courses";
			dbConnection = new DbConnection();
			connection = dbConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(fetchquery);
			
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				courseInfo = new CourseInfo();
				if(coursesList == null) {
					coursesList = new ArrayList<CourseInfo>();
				}
				courseInfo.setCourseId(rs.getInt(1));
				courseInfo.setCourseName(rs.getString(2));
				courseInfo.setDuration(rs.getString(3));
				courseInfo.setEligibility(rs.getString(4));
				courseInfo.setPlacementOpportunities(rs.getString(5));
				coursesList.add(courseInfo);
			}
			
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return coursesList;
	}

	/**
	 * Method to fetch a record by ID from courses table
	 * @param courseId
	 * @return
	 */
	public CourseInfo fetchCourseById(int courseId){
		DbConnection dbConnection = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		CourseInfo courseInfo = null;
		String fetchquery = null;
		ResultSet rs = null;
		
		try {
			fetchquery = "select * from courses where course_id = ?";
			dbConnection = new DbConnection();
			connection = dbConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(fetchquery);
			
			preparedStatement.setInt(1, courseId);
			
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				courseInfo = new CourseInfo();
				courseInfo.setCourseId(rs.getInt(1));
				courseInfo.setCourseName(rs.getString(2));
				courseInfo.setDuration(rs.getString(3));
				courseInfo.setEligibility(rs.getString(4));
				courseInfo.setPlacementOpportunities(rs.getString(5));
			}
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return courseInfo;
	}
	
	public List<CourseInfo> fetchCoursesByCollegeId(int collegeId){
		List<CourseInfo> coursesList = null;
		DbConnection dbConnection = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		CourseInfo courseInfo = null;
		String fetchquery = null;
		ResultSet rs = null;
		
		try {
			fetchquery = "select distinct c.* from courses c,colleges_courses_map ccm where c.course_id = ccm.course_id and ccm.college_id = ?";
			dbConnection = new DbConnection();
			connection = dbConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(fetchquery);
			preparedStatement.setInt(1, collegeId);
			
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				courseInfo = new CourseInfo();
				if(coursesList == null) {
					coursesList = new ArrayList<CourseInfo>();
				}
				courseInfo.setCourseId(rs.getInt(1));
				courseInfo.setCourseName(rs.getString(2));
				courseInfo.setDuration(rs.getString(3));
				courseInfo.setEligibility(rs.getString(4));
				courseInfo.setPlacementOpportunities(rs.getString(5));
				coursesList.add(courseInfo);
			}
			
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return coursesList;
	}
	
	
	public void deleteMappingsByCourseId(int courseId) {
		DbConnection dbConnection = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String deleteQuery = null;
		
		try {
			deleteQuery = "Delete from colleges_courses_map where course_id = ?";
			dbConnection = new DbConnection();
			connection = dbConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(deleteQuery);
		
			preparedStatement.setInt(1, courseId);
			
			preparedStatement.executeUpdate();
			
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public CourseInfo fetchCourseByName(String courseName){
		DbConnection dbConnection = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		CourseInfo courseInfo = null;
		String fetchquery = null;
		ResultSet rs = null;
		
		try {
			fetchquery = "select * from courses where course_name = ?";
			dbConnection = new DbConnection();
			connection = dbConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(fetchquery);
			
			preparedStatement.setString(1, courseName);
			
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				courseInfo = new CourseInfo();
				courseInfo.setCourseId(rs.getInt(1));
				courseInfo.setCourseName(rs.getString(2));
				courseInfo.setDuration(rs.getString(3));
				courseInfo.setEligibility(rs.getString(4));
				courseInfo.setPlacementOpportunities(rs.getString(5));
			}
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return courseInfo;
	}
	
}
