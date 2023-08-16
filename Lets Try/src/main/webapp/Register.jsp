<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body style="background-color: yellow;">
	<h2>Register here</h2>
	<form action="register" method="post" >
		<table class="myTable" style="align-items: center;">
			<tr>
				<th>Enter Name: </th>
				<th><input type="text" name="name" placeholder="Enter Name">
				</th>
			</tr>
			<tr>
				<td>Enter email: </td>
				<td><input type="email" name="email" placeholder="Enter email">
				</td>
			</tr>
			<tr>
				<td>Enter password: </td>
				<td><input type="password" name="password" placeholder="Enter password">
				</td>
			</tr>
			<tr><td><button type="submit" value="Register">Register</button></td></tr>

		</table>
	</form>
</body>
</html>