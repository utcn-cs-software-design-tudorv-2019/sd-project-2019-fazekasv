<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import ="com.project.drivingSchool.model.entity.User"%>
<!DOCTYPE html>
<html>
    
<head>
	<title>Trainee</title>
</head>
<body>
<h1>Trainee</h1>

<div>
	<div style="background-color:lightblue">
	<form action="updateTrainee" method="post">
		<span>Name</span>
		<input type="text" name="name" class="form-control input_user"
		 value=${name}> <br/> <br/>
		 <span>Age</span>
		 <input type="text" name="age" class="form-control input_user"
		 value=${age}> <br/> <br/>
		 <span>Address</span>
		 <input type="text" name="address" class="form-control input_user"
		 value=${address}><br/> <br/>
		 <button type="submit" name="Submit" value="button" class="btn login_btn">Update</button>
		 </form>
	</div>
	<br/> <br/>
	<div>
	<h1> Course Start Date: ${courseDate}</h1>
	
	 <div style="background-color:lightgreen">
	 <h2>Exams</h2>
	 <table>
	 <tr> 
	 <th>date</th>
	 <th>result</th>
	<c:forEach items="${exams}" var="entry"> 
  	<tr>
    	<td>${entry.examDate}</td>
    	<td>${entry.examResult}</td>
    </tr>
	</c:forEach>
</table>
<br/><br/>
</div>
<br/><br/>
	
	 <div>
	 	<a href="/exam">Take Exam</a>
	 </div>
	

</body>
</html>