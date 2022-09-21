<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">
 <link href="../css/homePage.css" rel="stylesheet">
</head>
<body class="home">
    <div class="container-fluid display-table">
    <br>
    <br>
        <div class="row display-table-row">
            <div class="col-md-2 col-sm-1 hidden-xs display-table-cell v-align box" id="navigation">
				 <div class="logo">
                    <a href="#"><img src="../images/course.jpg" alt="CRS" class="hidden-xs hidden-sm">
                    Course Recommender
                    </a>
                </div>
                <div class="navi">
                    <ul>
                        <li class="active"><a href="#"><i class="fa fa-home" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Home</span></a></li>
                        <li><a href="colleges.jsp"><i class="fa fa-institution" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Colleges</span></a></li>
                        <li><a href="courses.jsp"><i class="fa fa-book" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Courses</span></a></li>
                        <li><a href="students.jsp"><i class="fa fa-user" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Students</span></a></li>
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
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">User Name
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
                    <h1>Welcome, User Name</h1>
                </div>
            </div>
        </div>

    </div>

</body>
</html>