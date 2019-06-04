<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import ="com.project.drivingSchool.model.entity.User"%>
<!DOCTYPE html>
<html>
    
<head>
	<title>Register Trainer</title>
	<style>
	 
	</style>
</head>
<body>
<div>
<h1>Register Trainer</h1>

	<div>
		<form action="registerTrainer" method="post">
		<span>Username</span>
		<input type="text" name="username" class="form-control input_user" placeholder="username">
		  <br/> <br/>
		 <span>Password</span>
		 <input type="password" name="password" class="form-control input_pass" placeholder="password" >
		  <br/> <br/>
		  <span>First name</span>
		<input type="text" name="firstName" class="form-control input_user" placeholder="first name">
		  <br/> <br/>
		  <span>Last Name</span>
		<input type="text" name="lastName" class="form-control input_user" placeholder="last name">
		  <br/> <br/>
		  <span>Phone</span>
		<input type="text" name="phone" class="form-control input_user" placeholder="phone">
		  <br/> <br/>
		<span>Pass Fail Rate</span>
		<input type="text" name="passFail" class="form-control input_user" placeholder="pass fail rate">
		  <br/> <br/>
		 <button type="submit" name="Submit" value="button" class="btn login_btn">Register</button>
	 </form>
	</div>
</div>
</body>
</html>