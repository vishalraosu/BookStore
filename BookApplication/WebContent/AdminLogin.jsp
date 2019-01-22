<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Admin Login</title>
</head>
<body bgcolor="#483C46">
	<form action="/BookApplication/loginServlet" name="adminform"
		method="post">
		<center>
			<font color="#F4743B"><h1>ADMIN LOGIN</h1></font>
		</center>
		<table border=2 align="center" bgcolor="#BEEE62">
			<tr>
				<td>Enter admin name</td>
				<td><input type="text" name="name"
					placeholder="Admin-Name or e-mail"></td>
			</tr>

			<tr>
				<td>Enter admin password</td>
				<td><input type="password" name="pass" placeholder="Password"></td>
			</tr>

			<tr>
				<td colspan=2 align=center><input type="submit" name="asubmit"
					value="Login"></td>
				<a href="index.jsp" style="text-decoration: none"><font
					color=white>Go to Home Page</font></a>

			</tr>
			</form>
		</table>
		<%
			String msg1 = (String) request.getAttribute("msg1");
			if (msg1 != null) {
				out.print(msg1);
			}
		%>
	
</body>
</html>