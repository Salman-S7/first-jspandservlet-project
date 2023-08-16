<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div style="align-content: center;">
		<h2>Login here</h2>
		<form action="login" method="post">
			<table class="myTeble" style="align-items: center;">
				<tr>
					<th>Enter email:</th>
					<th><input type="email" name="email" placeholder="Enter email">
					</th>
				</tr>
				<tr>
					<td>Enter password:</td>
					<td><input type="password" name="password"
						placeholder="Enter password"></td>
				</tr>
				<tr>
					<td><button type="submit" value="Register">Login</button></td>
				</tr>

			</table>
			
		</form>
		
	</div>
</body>
</html>