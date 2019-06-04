<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import ="com.project.drivingSchool.model.entity.User"%>
<!DOCTYPE html>
<html>
    
<head>
	<title>Trainer</title>
</head>
<body>
<h1>Trainer</h1>
<div>
	<div style="background-color:lightblue">
	<form action="updateTrainer" method="post">
		<span>First name</span>
		<input type="text" name="firstName" class="form-control input_user"
		 value=${firstName}> <br/> <br/>
		 <span>Last name</span>
		 <input type="text" name="lastName" class="form-control input_user"
		 value=${lastName}> <br/> <br/>
		 <span>Phone</span>
		 <input type="text" name="phone" class="form-control input_user"
		 value=${phone}><br/> <br/>
		 <span>Pass rate(%):</span>
		 <input type="text" name="PassRate" class="form-control input_user"
		 value=${passRate}><br/> <br/>
		 <button type="submit" name="Submit" value="button" class="btn login_btn">Update</button>
		 </form>
	</div>
	
	 <br/> <br/>
	 <div style="background-color:lightgreen">
	 <h2>Vehicles</h2>
	 <table>
	 <tr> 
	 <th>brand</th>
	 <th>model</th>
	<c:forEach items="${vehicles}" var="element"> 
  	<tr>
    	<td>${element.brand}</td>
    	<td>${element.model}</td>
    </tr>
	</c:forEach>
</table>
<br/><br/>
	<form action="addVehicle" method="post">
	<span>Add Vehicle</span> <br/>
	<span>Brand</span>
		<input type="text" name="brand" class="form-control input_user"
		 value=${brand}> <br/> <br/>
		 <span>Model</span>
		 <input type="text" name="model" class="form-control input_user"
		 value=${model}> <br/> <br/>
		 <button type="submit" name="Submit" value="button" class="btn login_btn">Add Vehicle</button>
	 </form>
	 </div>
	 
	 <br/> <br/>
	 <div style="background-color:yellow">
	 <h2>Courses:</h2>
	 <table border="1">
	 <tr> 
	 <th>start date:</th>
	 <th>students</th>
	 <c:forEach items="${courses}" var="entry">
   	 	<tr>
   	 	<td>${entry.key.startDate}</td>
   	 	<td> <c:forEach items="${entry.value}" var="entry2">
   	 			<table border="1">
   	 			<tr><td>${entry2.name} ${entry2.age} ${entry2.address}</td></tr>
   	 			</table>
   	 		</c:forEach>
   	 	</td>
   	 	</tr>
	</c:forEach>
	
</table>
<br/><br/>
	<form action="addCourse" method="post">
	<span>Add Course</span> <br/>
	<span>StartDate</span>
		<input type="date" name="startDate" class="form-control input_user"
		 value=${startDate}> <br/> <br/>
		 <button type="submit" name="Submit" value="button" class="btn login_btn">Add Course</button>
	 </form>
	 </div>

</div>
</body>
</html>