<%@page import="com.intern.crs.object.CourseInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course Management</title>
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
String userRole = request.getSession().getAttribute("userRole").toString();
String userName = null;
if(userRole.equalsIgnoreCase("student")){
	userName = request.getSession().getAttribute("userName").toString();
}else{
	userName = "Administrator";
}

//get the list of courses from database
List<CourseInfo> courseList = (List<CourseInfo>)request.getSession().getAttribute("coursesList");
%>

<body class="home">
    <div class="container-fluid display-table">
    <br>
    <br>
        <div class="row display-table-row">
            <div class="col-md-2 col-sm-1 hidden-xs display-table-cell v-align box" id="navigation">
				 <div class="logo">
                    <a href="#"><img src="images/course.jpg" alt="CRS" class="hidden-xs hidden-sm">
                    Course Recommender
                    </a>
                </div>
                <div class="navi">
                    <ul>
                        <li><a href="home.jsp"><i class="fa fa-home" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Home</span></a></li>
                        <li><a href="FetchCollegesController"><i class="fa fa-institution" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Colleges</span></a></li>
                        <li class="active"><a href="#"><i class="fa fa-book" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Courses</span></a></li>
                        <%if(userRole.equalsIgnoreCase("admin")){ %>
                        <li><a href="FetchStudentsController"><i class="fa fa-user" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Students</span></a></li>
                        <%} %>
                    </ul>
                </div>
            </div>
            <div class="col-md-10 col-sm-11 display-table-cell v-align">
                <!--<button type="button" class="slide-toggle">Slide Toggle</button> -->
                <div class="row">
                    <header>
                            <div class="header-rightside">
                                <ul class="list-inline header-top pull-right">
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><%=userName %>
                                            <b class="caret"></b></a>
                                        <ul class="dropdown-menu">
                                            <li>
                                                <div class="navbar-content">
                                                    <a href="./login.jsp" style="color: black;">Log off</a>
                                                </div>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                    </header>
                </div>
                <div class="user-dashboard">
                	<div class="row">
                	<%if(userRole.equalsIgnoreCase("admin")){ %>
                		<a href="addNewCourse.jsp" class="btn btn-default" id="newCoursee">Add New Course</a>
                		<%} %>
                		<br>
                		<%-- <span><h6 style="color:red;">${message}</h6></span> --%>
                	</div>
                	<br>
                    <table id="coursesData" class="table table-striped table-bordered" style="width:100%">
                    <thead>
                    	<tr>
                    		<th>Course Name</th>
                    		<th>Duration</th>
                    		<th>Eligibility</th>
                    		<th>Placement Opportunities</th>
                    		<%if(userRole.equalsIgnoreCase("admin")){ %>
                    		<th>Action</th>
                    		 <% } %>
                    	</tr>
                    </thead>
                    <tbody>
                    
                    	 <%
                    if(null != courseList && (courseList.size() > 0)){
	                    for(CourseInfo course : courseList){
	                    	%><tr>
                    		<td>
                    			<a href="JavaScript:newPopup('collegesPopup.jsp?id=<%=course.getCourseId() %>');"> <%=course.getCourseName() %></a>
                    			</td>
                    		<td><%=course.getDuration() %></td>
                    		<td><%=course.getEligibility() %></td>
                    		<td><%=course.getPlacementOpportunities() %></td>
                    		
                    		<%if(userRole.equalsIgnoreCase("admin")){ %>
                    		<td> <a href="javascript:void(0);" name="CourseEdit" title="Edit Course" onclick="window.open('editCourse.jsp?id=<%=course.getCourseId() %>', '_self');">
                    		<i class="glyphicon glyphicon-edit"></i></a> /
                    		<a href="javascript:void(0);" name="CourseDelete" title="Delete Course" onclick="deleteItem('<%=course.getCourseId() %>')">
                    		<i class="glyphicon glyphicon-trash"></i></a>
                    		 </td>
                    		 <% } %>
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

<!-- script for delete college -->
<script type="text/javascript">
	function deleteItem(id){
		var checkStr = confirm("Are you sure you want to delete this?");
		if(checkStr == true){
			window.open("deleteCourse.jsp?id="+id, "_self");
		}else{
			return false;
		}
	}
	
</script>

<script type="text/javascript">
// Popup window code
function newPopup(url) {
	popupWindow = window.open(
		url,'popUpWindow','height=300,width=400,left=10,top=10,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no,status=yes');
}
</script>

</html>