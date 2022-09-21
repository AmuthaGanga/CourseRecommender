<%@page import="com.intern.crs.dao.CollegeDao"%>
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
CollegeDao collegeDao = new CollegeDao();
System.out.println("course id sent to popup-> " + Integer.parseInt(request.getParameter("id")));
//get the list of colleges from database
List<CollegeInfo> collegeList = collegeDao.fetchCollegesByCourseId(Integer.parseInt(request.getParameter("id")));
System.out.println("collegeList in popup window--> " + collegeList);
%>
<body class="home">
    <div class="container-fluid display-table">
    <br>
    <br>
        <div class="row display-table-row">
            <div class="col-md-10 col-sm-11 display-table-cell v-align">
                <div class="user-dashboard">
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
                    	</tr>
                    </thead>
                    <tbody>
                    <%
                    if(null != collegeList && (collegeList.size() > 0)){
	                    for(CollegeInfo college : collegeList){
	                    	%><tr>
                    		<td><%=college.getCollegeName() %> </td>
                    		<td><%=college.getCity() %></td>
                    		<td><%=college.getUniversity() %></td>
                    		<td><%=college.getWebsite() %></td>
                    		<td><%=college.getAccreditatedBy() %></td>
                    		<td><%=college.getNaacScore() %></td>
                    		
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

</html>