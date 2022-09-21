<%@page import="com.intern.crs.object.CourseInfo"%>
<%@page import="com.intern.crs.dao.CourseDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Course Details</title>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link href="css/registration.css" rel="stylesheet">

<!-- Password toggle -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
<script  src="/path/to/bootstrap-show-password.js"></script>
<script src="https://unpkg.com/bootstrap-show-password@1.2.1/dist/bootstrap-show-password.min.js"></script>

</head>
<body>
<div id="bgDiv" style="overflow:hidden;">
<div class="row">
    <div class="col-md-6 col-sm-12 col-lg-6 col-md-offset-3">
    <br><br>
    <%
    System.out.println("in edit college page..");
    	CourseDao courseDao = new CourseDao();
    	CourseInfo courseInfo = courseDao.fetchCourseById(Integer.parseInt(request.getParameter("id")));
    	System.out.println("in edit course page.. data is --> " + courseInfo.toString());
    %>
		<div class="panel panel-primary">
		<br>
			<div class="panel-heading">Update the College Details
			</div>
			<br>
			<div class="panel-body">
				<form id="identicalForm" name="myform" action="UpdateCourseController" method="post" >
				<input type="text" id="courseId" name="courseId" value="<%=request.getParameter("id")%>" hidden>
					<div class="form-group">
						<label for="courseName">College Name *</label>
						<input id="courseName" name="courseName" class="form-control vcheck" type="text" required value="<%=courseInfo.getCourseName()%>">
						<span id="error_courseName" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="duration">Duration *</label>
						<input id="duration" name="duration" class="form-control vcheck" type="text" required value="<%=courseInfo.getDuration()%>">
						<span id="error_duration" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="eligibility">Eligibility *</label>
						<input id="eligibility" name="eligibility" class="form-control vcheck" type="text" required value="<%=courseInfo.getEligibility()%>">
						<span id="error_eligibility" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="placement">Placement Opportunities *</label>
						<input type="text" id="placement" name="placement" class="form-control vcheck" required value="<%=courseInfo.getPlacementOpportunities()%>">
						<span id="error_placement" class="text-danger"></span>
					</div>
					<br>
					<div class="row" >
						<div style="float: left; padding-left: 200px">
							<button id="submit" type="submit" value="submit" class="btn btn-primary" disabled="disabled">Update Course</button>
						</div>
						<div style="float: right; padding-right: 200px">
							<a href="FetchCoursesController" class="btn btn-primary"> Cancel </a>
						</div>
					</div>
					<br><br>
				</form>

			</div>
		</div>
		<br><br><br><br>
	</div>
</div>
</div>
</body>

 <script>
        // On change in any of the fields with the class vcheck we run this function
        $('.vcheck').change(function() {
            // We store the values of each input field in a variable
            var courseName = $('#courseName').val();
            var duration = $('#duration').val();
            var eligibility = $('#eligibility').val();
            var placement = $('#placement').val();
            // We check for null (empty) values
            if (courseName == '' || duration == '' || eligibility == '' || placement == '') {
                // When we find something blank set or keep the button to disabled
                $('#submit').attr('disabled', 'disabled');
            } else {
                // When all conditions are met and values are good we enable the button
                $('#submit').removeAttr('disabled');
            }
        });
    </script>
  

</html>