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
<h1>Register Trainee</h1>

	<div>
		<form action="registerTrainee" method="post">
		<span>Username</span>
		<input type="text" name="username" class="form-control input_user" placeholder="username">
		  <br/> <br/>
		 <span>Password</span>
		 <input type="password" name="password" class="form-control input_pass" placeholder="password" >
		  <br/> <br/>
		  <span>Name</span>
		<input type="text" name="name" class="form-control input_user" placeholder="name">
		  <br/> <br/>
		  <span>Age</span>
		<input type="text" name="age" class="form-control input_user" placeholder="age">
		  <br/> <br/>
		  <span>Address</span>
		<input type="text" name="address" class="form-control input_user" placeholder="address">
		  <br/> <br/>
		  
		<select name="courseElem">
		<c:forEach items="${courses}" var="element"> 
    		<option value=${element.courseId}>${element.startDate}</option>
		</c:forEach>
		</select>
		  
		 <button type="submit" name="Submit" value="button" class="btn login_btn">Register</button>
	 </form>
	</div>
</div>
</body>
</html>