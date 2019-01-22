<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="UserLogin.css">
<title>BookStore:User Login/Registration Page</title>

</head>
<body>
	<div id="top" style='float: left'>

		<center>
			<h1>Welcome User!</h1>
		</center>
		<table align="right">
			<form action="/BookApplication/test" method="post">
				<tr>
					<td><label for="name"><b>User Name:</b></label></td>
					<td><input type="text" placeholder="Enter Username"
						name="name" required></td>
				</tr>
				<tr>
					<td><label for="pass"><b>Password: </b></label></td>
					<td><input type="password" placeholder="Enter Password"
						name="pass" required></td>
					<input type="hidden" name="first" value="first" >
				</tr>
				<tr>
					<td></td>
					<td><button class="button" type="submit">Login</button></td>
					
				</tr>
			</form>
		</table>

	</div>


	<p align="right">
		<font color="white" align="right"> <%
 	String msg = (String) request.getAttribute("msg");
 	if (msg != null) {
 		out.print(msg);
 	}
 %>
		</font>
	</p>

	<div id="header" style="height: 15%; width: 100%;">
		<div id="left" style='float: left'>
			<br /> <img src="book1.jpg" alt="Books" height="500" width="900">
		</div>
		<div id="left" style='float: right'>
			<form action="/BookApplication/register" method="post">
				<br /> <br /> <font color=white size=6><center>
						<b>Register Here!</b>
					</center></font>
				<table class="second" width="300px" height="400">
					<tr>
						<td><label for="name"><b>User Name:</b></label></td>
						<td align="right"><input type="text"
							placeholder="Enter Username" name="name" id="name" required></td>
					</tr>

					<tr>
						<td><label for="pass"><b>Password:</b></label></td>
						<td align="right"><input type="password"
							placeholder="Enter Password" name="pass" id="pass" required></td>
					</tr>

					<tr>
						<td><label for="phone"><b>Mobile:</b></label></td>
						<td align="right"><input type="text"
							placeholder="Enter Mobile Number" name="phone" id="phone"
							required></td>
					</tr>

					<tr>
						<td><label for="email"><b>Email:</b></label></td>
						<td align="right"><input type="email"
							placeholder="Enter Email Id" name="email" id="email" required></td>
					</tr>

					<tr>
						<td></td>
						<td><button class="button" type="submit"
								onclick="validation()">Register</button></td>
					</tr>
				</table>

			</form>
		</div>
	</div>
	<p align="right">
		<font color="white"> <%
 	String msg1 = (String) request.getAttribute("msg1");
 	if (msg1 != null) {
 		out.print(msg1);
 	}
 %>
		</font>
	</p>

</body>
</html>