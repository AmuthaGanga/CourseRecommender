<%@page import="com.intern.crs.dao.CollegeDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete College</title>
</head>

 <%
    	CollegeDao collegeDao = new CollegeDao();
 		collegeDao.deleteMappingsByCollegeId(Integer.parseInt(request.getParameter("id")));
 		int rowsDeleted = collegeDao.deleteCollegeInfo(Integer.parseInt(request.getParameter("id")));
 		if(rowsDeleted > 0){
 			response.sendRedirect("FetchCollegesController");
 		}
    %>
<body>

</body>
</html>