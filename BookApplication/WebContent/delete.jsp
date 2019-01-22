<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Form</title>
<head>

</head>
<div align="right">
	<font color="red" align="right" size="4"> <%
 	String name = (String) session.getAttribute("Username");
 	if (name != null) {
 		out.print("User:" + "\t" + name);
 	} else {
 		response.sendRedirect("index.jsp");
 	}
 %>
	</font>
	<form action="./logout" method="post">
		<input type="submit" value="logout">
	</form>
</div>
<body>
	<form name="deleteForm" action="/BookApplication/ModifyOperations"
		method="post">

		<center>
			<span style="filter: shadow(color = pink, direction = 135)"> <font
				color=red size=5>Delete Book Details</font>
				<hr color=orange width=50%>
			</span>
		</center>

		<table border=1 cellpadding=4 cellspacing=4 align=center
			bgcolor='lavender'>

			<td>Enter Book Id:<input type="text" name="book_id"
				placeholder="Enter the book id" required />
			</td>
			<br>
			<td><input type="submit" value="delete" name="button_type"></td>
			<td><input type="reset" value="Cancel"></td>
		</table>
		<a href="/BookApplication/UserChoice.jsp"> Click here to go to
			user choice</a>
	</form>
	<%
		if (request.getAttribute("Msg") != null) {

			out.print(request.getAttribute("Msg"));
		}
	%>

</body>
</html>