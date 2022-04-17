<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Todo</title>
</head>
<body>
	<form action="edit" method="post">
		List ID : <input type="number" name = "id"> <br> <br>
		Type    : <input type="text" name = "type" > <br> <br>
		Description : <input type="text" name = "description"> <br> <br>
		List Priority : <input type="number" name = "priority"> <br> <br>
		<input type="submit" value = "SAVE">
	</form>
</body>
</html>