<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Please</title>
</head>
<body>
	Please login here ${name}
	<pre>${errorMessage}</pre>
	<form method="post">
	Name: <input type="text" name="name">
	Password: <input type="password" name="password">
	<input type="submit">
	</form>
</body>
</html>