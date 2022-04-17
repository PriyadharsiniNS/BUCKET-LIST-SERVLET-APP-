<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<form action="">
	<h1 style="text-align:center; 
		font-size: 20px; 
		font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
		position: absolute;
		margin-top: 100px;
		margin-left:250px;">
			WELCOME TO BUCKET LIST APP!!!
	</h1>
	<h2 style="text-align:center; 
		font-size: 15px; 
		font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
		position: absolute;
		margin-top:150px;
		margin-left:320px;">
		DO SOMETHING!!!
	</h2>
	</form>
	<form action="Add2.jsp" method="post">
		<input type="submit" value = "ADD" style="position:absolute; margin-top:200px; margin-left:280px;">
	</form>
	
	<form action="Edit.jsp" method="post">
	<input type="submit" name="edit" value="EDIT" style="position:absolute; margin-top:200px; margin-left:350px;">
	</form>
	
	<form action="List.jsp" method="post">
	<input type="submit" name="viewlist1" value="SHOW LIST" style="position:absolute; margin-top:200px; margin-left:430px;"> <br><br>
	</form>
	
	<form action="List By Type.jsp" method="post">
	<input type="submit" name="viewlist2" value="SHOW LIST BY TYPE" style="position:absolute; margin-top:210px; margin-left:280px;">
	</form>
	
	<form action="Delete.jsp" method="post">
	<input type="submit" name="delete" value="DELETE" style="position:absolute; margin-top:210px; margin-left:460px;">
	</form>
</body>
</html>