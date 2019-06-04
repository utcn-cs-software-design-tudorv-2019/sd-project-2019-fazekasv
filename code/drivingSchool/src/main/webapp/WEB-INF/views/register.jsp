<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import ="com.project.drivingSchool.model.entity.User"%>
<!DOCTYPE html>
<html>
    
<head>
	<title>Register</title>
	<style>
	a:link {
	border: 1px;
	padding: 10px;
		background-color:grey;
	}
	</style>
</head>
<body>
<h1>Register</h1>
<div class="d-flex justify-content-center">
	<div>
		<a href="/registerTrainee">Register Trainee</a>
	</div>
	
	 <br/> <br/>
	 <div>
	 	<a href="/registerTrainer">Register trainer</a>
	 </div>

</div>
</body>
</html>