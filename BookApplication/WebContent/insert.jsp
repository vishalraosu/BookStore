<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
	<form action="/BookApplication/ModifyOperations" method="post"
		name="newauthor">
		<center>
			<span style="filter: shadow(color = pink, direction = 135)"> <font
				color=red size=5>Insert Book Details</font>
				<hr color=orange width=50%>
			</span>
		</center>
		<table border=1 cellpadding=4 cellspacing=4 align=center
			bgcolor='lavender'>

			<tr>
				<td>Enter Book ID:</td>
				<td align="center"><input type="number" name="book_id" id="id"
					size="20" maxlength="4" placeholder="Enter Book_Id" required></td>
			</tr>
			<tr>
				<td>Enter Book Name</td>
				<td align="center"><input type="text" name="book_name"
					id="name" size="20" maxlength="30" placeholder="Enter Book_Name"
					required></td>
			</tr>
			<tr>
				<td>Enter Author Name</td>
				<td align="center"><input type="text" name="author_name"
					id="aname" size="20" maxlength="30" placeholder="Enter Author_Name"
					required></td>
			</tr>
			<tr>
				<td>Enter Book Category</td>
				<td align="center"><input type="text" name="book_category"
					id="category" size="20" maxlength="30"
					placeholder="Enter Book_Category" required></td>
			</tr>
			<tr>
				<td>Enter Book Status</td>
				<td align="center"><select id="status" name="book_status"
					required>
						<option>Available</option>
						<option>Not-Available</option>
				</select></td>
			</tr>
			<tr>
				<td align="center"><input type="reset" value="Cancel"></td>
				<td align="center"><input type="submit" value="insert"
					name="button_type"></td>

			</tr>
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