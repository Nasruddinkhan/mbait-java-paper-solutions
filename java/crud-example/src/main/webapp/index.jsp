<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/crud-example/StudentController" method="post">
		<table align="center" border="1" align="center" bordercolor="#CCCCCC" border="1" style="border-collapse: collapse;" cellpadding="3px">
			<tr>
				<td >Id:</td>
				<td><input type="text" name="id"/></td>
			</tr>
			
			<tr>
				<td >First Name:</td>
				<td><input type="text" name="firstName"/></td>
			</tr>
			<tr>
				<td >Last Name:</td>
				<td><input type="text" name="lastName"/></td>
			</tr>
			<tr>
				<td >Email:</td>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<td >Mobile Number:</td>
				<td><input type="text" name="mobileno"/></td>
			</tr>
			<tr>
			<td colspan="2" align="center">
			 <button type="submit"> Register</button>
			</td>
			<tr>
		</table>
	</form>
</body>
</html>