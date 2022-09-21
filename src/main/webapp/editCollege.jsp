<%@page import="java.util.ArrayList"%>
<%@page import="com.intern.crs.object.CourseInfo"%>
<%@page import="java.util.List"%>
<%@page import="com.intern.crs.dao.CourseDao"%>
<%@page import="com.intern.crs.object.CollegeInfo"%>
<%@page import="com.intern.crs.dao.CollegeDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update College Details</title>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link href="css/registration.css" rel="stylesheet">

<!-- Password toggle -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
<script  src="/path/to/bootstrap-show-password.js"></script>
<script src="https://unpkg.com/bootstrap-show-password@1.2.1/dist/bootstrap-show-password.min.js"></script>

</head>

<%
	CourseDao courseDao = new CourseDao();
	List<CourseInfo> courses = courseDao.fetchAllCourses();
	System.out.println("courses --> " + courses);
	System.out.println("courses size --> " +courses.size());
%>

<body>
<div id="bgDiv" style="overflow:hidden;">
<div class="row">
    <div class="col-md-6 col-sm-12 col-lg-6 col-md-offset-3">
    <br><br>
    <%
    System.out.println("in edit college page..");
    	CollegeDao collegeDao = new CollegeDao();
    	CollegeInfo collegeInfo = collegeDao.fetchCollegeByIdWithCoursesList(Integer.parseInt(request.getParameter("id")));
    	List<CourseInfo> availableCourses = collegeInfo.getCoursesList();
    	System.out.println("in edit college page.. data is --> " + collegeInfo.toString());
    	List<CourseInfo> modifiedCourses = new ArrayList<CourseInfo>();
    	modifiedCourses.addAll(courses);
    			
    	// to remove existing courses
    	if(null != availableCourses && availableCourses.size() > 0 && null != courses && courses.size() > 0){
			for(CourseInfo course : courses){
				for(CourseInfo course1 : availableCourses){
					if(course.getCourseId() == course1.getCourseId()){
						modifiedCourses.remove(course);
					}
				}
			}
    	}
    	System.out.println("courses after removal --> " + modifiedCourses);
    	System.out.println("modifiedCourses size --> " +modifiedCourses.size());
    %>
		<div class="panel panel-primary">
			<div class="panel-heading">Update the College Details
			</div>
			<div class="panel-body">
				<form id="identicalForm" name="myform" action="UpdateCollegeController" method="post" >
				<input type="text" id="collegeId" name="collegeId" value="<%=request.getParameter("id")%>" hidden>
					<div class="form-group">
						<label for="collegeName">College Name *</label>
						<input id="collegeName" name="collegeName" class="form-control vcheck" type="text" required value="<%=collegeInfo.getCollegeName()%>">
						<span id="error_collegeName" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="city">City *</label>
						<input id="city" name="city" class="form-control vcheck" type="text" required value="<%=collegeInfo.getCity()%>">
						<span id="error_city" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="university">University *</label>
						<input id="university" name="university" class="form-control vcheck" type="text" required value="<%=collegeInfo.getUniversity()%>">
						<span id="error_university" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="website">Website *</label>
						<input type="text" id="website" name="website" class="form-control vcheck" required value="<%=collegeInfo.getWebsite()%>">
						<span id="error_website" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="accreditatedBy">Accreditated By *</label>
						<input type="text" id="accreditatedBy" name="accreditatedBy" class="form-control vcheck" required value="<%=collegeInfo.getAccreditatedBy()%>">
						<span id="error_accreditatedBy" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="naacScore">NAAC Score *</label>
						<input type="text" id="naacScore" name="naacScore" class="form-control vcheck" required value="<%=collegeInfo.getNaacScore()%>" onchange="changeScore()">
						<span id="error_naacScore" class="text-danger"></span>
					</div>
					
					<div class="row">
						<div class="col-md-3 col-sm-12 col-xs-12">
							<label for="coursesList">Select Courses *</label>
						</div>
						<div class="col-md-4 col-sm-12 col-xs-12"> 
							<select name="selectionList"  id="selectionList" class="form-control" multiple="multiple">
								<% for(CourseInfo course : modifiedCourses) { %>
								<option value="<%=course.getCourseId() %>"><%=course.getCourseName() %> </option>
								<% } %>
							</select>
						</div>
						
						<div class="col-md-1 col-sm-12 col-xs-12">
							<div class="panel text-center">
								<button type="button" class="btn btn-default" name="addCourse" id="addCourse" onClick="listbox_moveacross('selectionList', 'selectedList')">>></button>
							</div>
							<div class="panel text-center">
								<button type="button" class="btn btn-default" name="addCourse" id="addCourse" onClick="listbox_moveacross('selectedList', 'selectionList')"><<</button>
							</div>
						</div>
						
						<div class="col-md-4 col-sm-12 col-xs-12"> 
							<select name="selectedList"  id="selectedList" class="form-control vcheck" multiple="multiple" required>
								<% 
								if(null != availableCourses && availableCourses.size() > 0){
									for(CourseInfo course : availableCourses){
										 %>
										<option selected value="<%=course.getCourseId() %>"><%=course.getCourseName() %></option>
								<% }	
								} %> 
							</select>
						</div>
						
					</div>
					<div class="row" >
						<div style="float: left; padding-left: 200px">
							<button id="submit" type="submit" value="submit" class="btn btn-primary" >Update College</button>
						</div>
						<div style="float: right; padding-right: 200px">
							<a href="FetchCollegesController" class="btn btn-primary"> Cancel </a>
						</div>
					</div>
					<br><br>
				</form>

			</div>
		</div>
	</div>
</div>
</div>
</body>

 <!-- <script>
        // On change in any of the fields with the class vcheck we run this function
        $('.vcheck').change(function() {
            // We store the values of each input field in a variable
            var collegeName = $('#collegeName').val();
            var city = $('#city').val();
            var university = $('#university').val();
            var website = $('#website').val();
            var accreditatedBy = $('#accreditatedBy').val();
            var naacScore = $('#naacScore').val();
            // We check for null (empty) values
            if (collegeName == '' || city == '' || university == '' || website == '' || accreditatedBy == '' || naacScore == '') {
                // When we find something blank set or keep the button to disabled
                $('#submit').attr('disabled', 'disabled');
            } else {
                // When all conditions are met and values are good we enable the button
                $('#submit').removeAttr('disabled');
            }
        });
    </script> -->
    
        <!-- to check if the NAAC score is above 0 and below 4.0 -->
    <script>
    	function changeScore() {
           var naacScore = $('#naacScore').val();
           if (naacScore <= 0 || naacScore > 4.0) {
 	          	document.getElementById("naacScore").value="";
               window.alert("NAAC score should be between 0.0 and 4.0")
           }
           
       }
    </script>
  
      <script type="text/javascript">
    
    function listbox_moveacross(sourceId, destId){
    	console.log('in function listbox_moveacross');
    	console.log(sourceId);
    	console.log(destId);
    	var src = document.getElementById(sourceId);
    	var dest = document.getElementById(destId);
    	
    	console.log(src);
    	for(var count=0; count<src.options.length; count++){
    		console.log('in for loop');
    		if(src.options[count].selected == true){
    			console.log('selected true');
    			var option = src.options[count];
    			
    			var newOption = document.createElement("option");
    			console.log(option.value);
    			console.log(option.text);
    			newOption.value = option.value;
    			newOption.text = option.text;
    			newOption.selected = true;
    			try{
    				dest.add(newOption, null);
    				src.remove(count, null);
    			}catch(error){
    				alert(error);
    				dest.add(newOption);
    				src.remove(count);
    			}
    			count--;
    		}
    	}
    }
    
    </script>

</html>