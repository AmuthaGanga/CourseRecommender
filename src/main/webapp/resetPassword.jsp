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
    <br><br>
		<div class="panel panel-primary">
		<br><br>
			<div class="panel-heading">Reset your password
			</div>
			<div class="panel-body">
				<form id="identicalForm" name="myform" action="ResetPasswordController" method="post" oninput='confirmPassword.setCustomValidity(confirmPassword.value != password.value ? "Passwords do not match." : "")'>
					
					<div class="form-group">
						<label for="email">Email *</label>
						<input type="email" id="email" name="email" class="form-control" readonly="readonly" value="<%=request.getParameter("id") %>">
						<span id="error_email" class="text-danger"></span>
					</div>

					<div class="form-group">
                        <label for="password">Enter your new password *</label><br>
                        <input type="password" name="password" id="password" class="form-control vcheck" data-toggle="password" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Password must contain: Minimum 8 characters atleast 1 uppercase and lowercase Alphabet and 1 Number">
                    </div>
                    <div class="form-group">
                        <label for="confirmPassword">Confirm Password *</label><br>
                        <input type="password" name="confirmPassword" id="confirmPassword" class="form-control vcheck" data-toggle="password" >
                    </div>
					<button id="submit" type="submit" value="submit" class="btn btn-primary" disabled="disabled">Reset Password</button>

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
            var password = $('#password').val();
            var confirmPassword = $('#confirmPassword').val();
            // We check for null (empty) values
            if (password == '' || confirmPassword == '') {
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