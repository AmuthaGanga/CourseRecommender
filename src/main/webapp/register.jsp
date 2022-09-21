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
<link href="css/registration.css" rel="stylesheet">

<!-- Password toggle -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
<script  src="/path/to/bootstrap-show-password.js"></script>
<script src="https://unpkg.com/bootstrap-show-password@1.2.1/dist/bootstrap-show-password.min.js"></script>

</head>
<body>
<div id="bgDiv">
<div class="row">
    <div class="col-md-6 col-sm-12 col-lg-6 col-md-offset-3">
		<div class="panel panel-primary">
			<div class="panel-heading">Enter Your Details Here
			</div>
			<div class="panel-body">
				<form id="identicalForm" name="myform" action="RegistrationController" method="post" oninput='confirmPassword.setCustomValidity(confirmPassword.value != password.value ? "Passwords do not match." : "")'>
					<div class="form-group">
						<label for="firstName">First Name *</label>
						<input id="firstName" name="firstName" class="form-control vcheck" type="text" required pattern="[a-zA-Z ]+"  
						oninvalid="this.setCustomValidity('Enter only alphabets')" oninput="this.setCustomValidity('')"  >
						<span id="error_name" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="lastName">Last Name *</label>
						<input id="lastName" name="lastName" class="form-control vcheck" type="text" required pattern="[a-zA-Z ]+"  
						oninvalid="this.setCustomValidity('Enter only alphabets')" oninput="this.setCustomValidity('')" >
						<span id="error_lastName" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="dob">Date Of Birth *</label>
						<input type="date" name="dob" id="dob" class="form-control vcheck" required>
						<span id="error_dob" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="gender">Gender *</label>
						<select name="gender" id="gender" class="form-control vcheck" required>
							<option value="" disabled selected hidden>Select...</option>
							<option>Male</option>
							<option>Female</option>
							<option>Other</option>
						</select>
						<span id="error_gender" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="phone">Phone Number *</label>
						<input type="text" id="phone" name="phone" class="form-control vcheck" required pattern="[0-9]{10,10}"  
						oninvalid="this.setCustomValidity('Please enter a 10 digit mobile number')" oninput="this.setCustomValidity('')" >
						<span id="error_phone" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="email">Email *</label>
						<input type="email" id="email" name="email" class="form-control vcheck" required>
						<span id="error_email" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="address">Address</label>
						<textarea class="form-control" rows="3" id="address" name="address"></textarea>
					</div>
					<div class="form-group">
                        <label for="password">Password *</label><br>
                        <input type="password" name="password" id="password" class="form-control vcheck" data-toggle="password" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Password must contain: Minimum 8 characters atleast 1 uppercase and lowercase Alphabet and 1 Number">
                    </div>
                    <div class="form-group">
                        <label for="confirmPassword">Confirm Password *</label><br>
                        <input type="password" name="confirmPassword" id="confirmPassword" class="form-control vcheck" data-toggle="password" >
                    </div>
					<div class="row" >
					<div style="float: left; padding-left: 200px">
					<button id="submit" type="submit" value="submit" class="btn btn-primary" disabled="disabled">Register</button>
					</div>
					<div style="float: right; padding-right: 200px">
					<a href="./login.jsp" class="btn btn-primary"> Cancel </a>
					</div>
					</div>
				</form>

			</div>
		</div>
	</div>
</div>
</div>
</body>

 <script>
        // On change in any of the fields with the class vcheck we run this function
        $('.vcheck').change(function() {
            // We store the values of each input field in a variable
            var firstName = $('#firstName').val();
            var lastName = $('#lastName').val();
            var dob = $('#dob').val();
            var select = document.getElementById('gender');
            var gender = select.options[select.selectedIndex].value;
            var email = $('#email').val();
            var phone = $('#phone').val();
            var password = $('#password').val();
            var confirmPassword = $('#confirmPassword').val();
            // We check for null (empty) values
            if (firstName == '' || lastName == '' || dob == '' || gender == '' || email == '' || phone == '' || password == '' || confirmPassword == '') {
                // When we find something blank set or keep the button to disabled
                $('#submit').attr('disabled', 'disabled');
            } else {
                // When all conditions are met and values are good we enable the button
                $('#submit').removeAttr('disabled');
            }
        });
    </script>
  
  <!-- To set the max date as today in date picker -->  
    <script type="text/javascript">

    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1; //January is 0!
    var yyyy = today.getFullYear();

    if (dd < 10) {
       dd = '0' + dd;
    }

    if (mm < 10) {
       mm = '0' + mm;
    } 
        
    today = yyyy + '-' + mm + '-' + dd;
    document.getElementById("dob").setAttribute("max", today);
    	  	
    </script>
    
    <!-- to check if the user is of age above 18 -->
    <script>
        $('#dob').change(function() {
            // We store the values of each input field in a variable
            var dob = $('#dob').val();
            var today = new Date();
            var birthDate = new Date(dob);
            var age = today.getFullYear() - birthDate.getFullYear();
            var m = today.getMonth() - birthDate.getMonth();
            if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
                age--;
            }
            
            if(age < 18){
            	var confirm = window.confirm("Below 18 are not eligible to use this portal.");
            	if(confirm){
            		window.location = "login.jsp"
            	}
            	
            }
            
        });
    </script>

</html>