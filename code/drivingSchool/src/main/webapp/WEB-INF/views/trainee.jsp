
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
	
	

</body>
</html>