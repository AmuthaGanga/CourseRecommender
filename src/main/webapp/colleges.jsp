<%@page import="com.intern.crs.object.CollegeInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>College Management</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">
 <link href="css/homePage.css" rel="stylesheet">
 
 <!-- DataTables related file references -->
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs5/jq-3.6.0/dt-1.12.1/b-2.2.3/b-html5-2.2.3/cr-1.5.6/r-2.3.0/sp-2.0.2/datatables.min.css"/>
 
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs5/jq-3.6.0/dt-1.12.1/b-2.2.3/b-html5-2.2.3/cr-1.5.6/r-2.3.0/sp-2.0.2/datatables.min.js"></script>
</head>

<%
String userRole = request.getSession().getAttribute("userRole").toString();
String userName = null;
if(userRole.equalsIgnoreCase("student")){
	userName = request.getSession().getAttribute("userName").toString();
}else{
	userName = "Administrator";
}

//get the list of colleges from database
List<CollegeInfo> collegeList = (List<CollegeInfo>)request.getSession().getAttribute("collegesList");
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
                        <li class="active"><a href="#"><i class="fa fa-institution" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Colleges</span></a></li>
                        <li><a href="FetchCoursesController"><i class="fa fa-book" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Courses</span></a></li>
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
                		<a href="addNewCollege.jsp" class="btn btn-default" id="newCollege">Add New College</a>
                		<%} %>
                		<br>
                		<%-- <span><h6 style="color:red;">${message}</h6></span> --%>
                	</div>
                	<br>
                    <table id="collegeData" class="table table-striped table-bordered" style="width:100%">
                    <thead>
                    	<tr>
                    		<th>College Name</th>
                    		<th>City</th>
                    		<th>University</th>
                    		<th>Website</th>
                    		<th>Accreditated by</th>
                    		<th>NAAC Score</th>
                    		<%if(userRole.equalsIgnoreCase("admin")){ %>
                    		<th>Action</th>
                    		 <% } %>
                    	</tr>
                    </thead>
                    <tbody>
                    <%
                    if(null != collegeList && (collegeList.size() > 0)){
	                    for(CollegeInfo college : collegeList){
	                    	%><tr>
                    		<td>
                    			<a href="JavaScript:newPopup('coursesPopup.jsp?id=<%=college.getCollegeId() %>');"> <%=college.getCollegeName() %> </a>
                    		</td>
                    		<td><%=college.getCity() %></td>
                    		<td><%=college.getUniversity() %></td>
                    		<td><%=college.getWebsite() %></td>
                    		<td><%=college.getAccreditatedBy() %></td>
                    		<td><%=college.getNaacScore() %></td>
                    		
                    		<%if(userRole.equalsIgnoreCase("admin")){ %>
                    		<td> <a href="javascript:void(0);" name="CollegeEdit" title="Edit College" onclick="window.open('editCollege.jsp?id=<%=college.getCollegeId() %>', '_self');">
                    		<i class="glyphicon glyphicon-edit"></i></a> /
                    		<a href="javascript:void(0);" name="CollegeDelete" title="Delete College" onclick="deleteItem('<%=college.getCollegeId() %>')">
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
			window.open("deleteCollege.jsp?id="+id, "_self");
		}else{
			return false;
		}
	}
	
</script>

<!-- script for data table -->
<script type="text/javascript">
//$(document).ready( function () {
    var table =  $('#collegeData').DataTable({
    	buttons : [
    		'pdf'
    		]
    });
//} );
</script>

<script type="text/javascript">
// Popup window code
function newPopup(url) {
	popupWindow = window.open(
		url,'popUpWindow','height=300,width=400,left=10,top=10,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no,status=yes');
}
</script>

</html>