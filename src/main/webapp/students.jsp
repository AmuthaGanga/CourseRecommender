<%@page import="com.intern.crs.object.UserInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Members</title>
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
    $('#studentData').DataTable();
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

//get the list of colleges from database
List<UserInfo> userList = (List<UserInfo>)request.getSession().getAttribute("usersList");
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
                        <li><a href="FetchCoursesController"><i class="fa fa-book" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Courses</span></a></li>
                        <li class="active"><a href="#"><i class="fa fa-user" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Students</span></a></li>
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
                <br><br>
                    <table id="studentData" class="table table-striped table-bordered" style="width:100%">
                    <thead>
                    	<tr>
                    		<th>First Name</th>
                    		<th>Last Name</th>
                    		<th>DoB</th>
                    		<th>Gender</th>
                    		<th>Phone</th>
                    		<th>Email</th>
                    	</tr>
                    </thead>
                    <tbody>
                    <%
                    if(null != userList && (userList.size() > 0)){
	                    for(UserInfo user : userList){
	                    %><tr>
                    		<td><%=user.getFirstName()%></td>
                    		<td><%=user.getLastName() %></td>
                    		<td><%=user.getDob()%></td>
                    		<td><%=user.getGender()%></td>
                    		<td><%=user.getPhone_number() %></td>
                    		<td><%=user.getEmail() %></td>
                    		</tr>
	               <%
	                    }
                    }
                    	 %>
                    	<!-- <tr>
                    		<td>Santhosh</td>
                    		<td>Rajendran</td>
                    		<td>23-07-2004</td>
                    		<td>7754632890</td>
                    		<td>santhosh@gmail.com</td>
                    		<td>No 20, Shrishti Apartment, BB Kulam, Madurai </td>
                    	</tr>
                    	<tr>
                    		<td>Malar</td>
                    		<td>Kumar</td>
                    		<td>12-11-2002</td>
                    		<td>9894567329</td>
                    		<td>malar@gmail.com</td>
                    		<td>No 5, II street, Gandhi Nagar, Madurai </td>
                    	</tr>
                    	<tr>
                    		<td>Richi</td>
                    		<td>Gupta</td>
                    		<td>30-06-2004</td>
                    		<td>9994567832</td>
                    		<td>richi@gmail.com</td>
                    		<td>20A, Krishnasamy street, BB Kulam, Madurai </td>
                    	</tr> -->
                    </tbody>
                                  
                    </table>
                </div>
            </div>
        </div>

    </div>

</body>
</html>