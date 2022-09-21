<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link href="../css/registration.css" rel="stylesheet">

</head>
<body>
<div id="bgDiv">
<div class="row">
    <div class="col-md-6 col-sm-12 col-lg-6 col-md-offset-3">
		<div class="panel panel-primary">
			<div class="panel-heading">Enter Your Details Here
			</div>
			<div class="panel-body">
				<form id="identicalForm" name="myform" action="" method="post" oninput='confirmPassword.setCustomValidity(confirmPassword.value != password.value ? "Passwords do not match." : "")'>
					<div class="form-group">
						<label for="myName">First Name *</label>
						<input id="myName" name="myName" class="form-control" type="text" required pattern="[a-zA-Z ]+"  
						oninvalid="this.setCustomValidity('Enter only alphabets')" oninput="this.setCustomValidity('')"  >
						<span id="error_name" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="lastname">Last Name *</label>
						<input id="lastname" name="lastname" class="form-control" type="text" required pattern="[a-zA-Z ]+"  
						oninvalid="this.setCustomValidity('Enter only alphabets')" oninput="this.setCustomValidity('')" >
						<span id="error_lastname" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="dob">Date Of Birth *</label>
						<input type="date" name="dob" id="dob" class="form-control" required>
						<span id="error_dob" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="gender">Gender</label>
						<select name="gender" id="gender" class="form-control" >
							<option selected>Male</option>
							<option>Female</option>
							<option>Other</option>
						</select>
						<span id="error_gender" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="phone">Phone Number *</label>
						<input type="text" id="phone" name="phone" class="form-control" required pattern="[0-9]{10,10}"  
						oninvalid="this.setCustomValidity('Please enter a 10 digit mobile number')" oninput="this.setCustomValidity('')" >
						<span id="error_phone" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="email">Email *</label>
						<input type="email" id="email" name="email" class="form-control" required>
						<span id="error_email" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="address">Address</label>
						<textarea class="form-control" rows="3" id="address" name="address"></textarea>
					</div>
					<div class="form-group">
                        <label for="password">Password:</label><br>
                        <input type="password" name="password" id="password" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="confirmPassword">Confirm Password:</label><br>
                        <input type="password" name="confirmPassword" id="confirmPassword" class="form-control">
                    </div>

					<button id="submit" type="submit" value="submit" class="btn btn-primary center">Submit</button>
			
				</form>

			</div>
		</div>
	</div>
</div>
</div>
</body>



</html>