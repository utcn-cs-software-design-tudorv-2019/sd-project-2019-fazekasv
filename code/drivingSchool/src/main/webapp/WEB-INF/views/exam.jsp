
<!DOCTYPE html>
<html>
    
<head>
	<title>Trainee</title>
</head>
<body>
<h1>Trainee</h1>

<div>
	<div style="background-color:lightblue">
	<h1>Score: ${score}</h1>
	<h1>Mistakes: ${mistake}</h1>
	<form action="answerQuestion" method="post">
		<span>Question: ${question}</span>
		<br/> <br/>
		 <input type="checkbox" name="a" class="form-control input_user">
		 <span>a). ${a}</span><br/> <br/>
		 
		 <input type="checkbox" name="b" class="form-control input_user">
		  <span>b). ${b}</span> <br/> <br/>
		  
		 <input type="checkbox" name="c" class="form-control input_user">
		 <span>c). ${c}</span> <br/> <br/>
		 <button type="submit" name="Submit" value="button" class="btn login_btn">Next</button>
		 </form>
	</div>
	<br/> <br/>

</body>
</html>