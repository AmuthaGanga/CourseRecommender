<%@page import="com.intern.crs.dao.CourseDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Colurse</title>
</head>

 <%
    	CourseDao courseDao = new CourseDao();
 		courseDao.deleteMappingsByCourseId(Integer.parseInt(request.getParameter("id")));
 		int rowsDeleted = courseDao.deleteCourseInfo(Integer.parseInt(request.getParameter("id")));
 		if(rowsDeleted > 0){
 			response.sendRedirect("FetchCoursesController");
 		}
    %>
<body>

</body>
</html>