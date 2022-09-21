<%@page import="com.intern.crs.dao.CourseDao"%>
<%@page import="com.intern.crs.object.CourseInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Courses List</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">
 <link href="css/homePage.css" rel="stylesheet">
 
 <!-- DataTables related file references -->
<!--  <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">  -->
<link href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css" rel="stylesheet" id="bootstrap-css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js"></script>
</head>

<script type="text/javascript">
$(document).ready( function () {
    $('#coursesData').DataTable();
} );
</script>

<%
	CourseDao courseDao = new CourseDao();
	List<CourseInfo> courseList = courseDao.fetchCoursesByCollegeId(Integer.parseInt(request.getParameter("id")));
	System.out.println("courses --> " + courseList);
%>

<body class="home">
    <div class="container-fluid display-table">
    <br>
    <br>
        <div class="row display-table-row">

            <div class="col-md-10 col-sm-11 display-table-cell v-align">
                <div class="user-dashboard">
                	<br>
                    <table id="coursesData" class="table table-striped table-bordered" style="width:100%">
                    <thead>
                    	<tr>
                    		<th>Course Name</th>
                    		<th>Duration</th>
                    		<th>Eligibility</th>
                    		<th>Placement Opportunities</th>
                    	</tr>
                    </thead>
                    <tbody>
                    
                    	 <%
                    if(null != courseList && (courseList.size() > 0)){
	                    for(CourseInfo course : courseList){
	                    	%><tr>
                    		<td><%=course.getCourseName() %></td>
                    		<td><%=course.getDuration() %></td>
                    		<td><%=course.getEligibility() %></td>
                    		<td><%=course.getPlacementOpportunities() %></td>
                    		
                    		</tr>
	               <%
	                    }
                    }
                    	 %>
                    	 
                    </tbody>
                                  
                    </table>
                </div>
            </div>
        </div>

    </div>

</body>


</html>