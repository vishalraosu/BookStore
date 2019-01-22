<html>

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
	<form action="/BookApplication/ModifyOperations" method="post">
		<center>
			<span style="filter: shadow(color = pink, direction = 135)"> <font
				color=red size=5>Update Book Details</font>
				<hr color=orange width=50%>
			</span>
		</center>
		<table border="1px" cellpadding="4" cellspacing="4" align=center
			bgcolor='lavender'>
			<tr>
				<td>Enter the book ID</td>
				<td><input type="text" name="book_id"
					placeholder="Enter the old id"></td>
			</tr>
			<tr>
				<td>Enter the book name</td>
				<td><input type="text" name="book_name"
					placeholder="Enter the new book name"></td>
			</tr>

			<tr>
				<td>Enter the author name</td>
				<td><input type="text" name="author_name"
					placeholder="Enter the author name"></td>
			</tr>

			<tr>
				<td>Enter the category</td>
				<td><input type="text" name="book_category"
					placeholder="Enter the book category"></td>
			</tr>

			<tr>
				<td>Enter the status</td>
				<td><input type="text" name="book_status"
					placeholder="Enter the book status"></td>
			</tr>


			<tr>
				<td><input type="reset" value="Cancel"></td>
				<td><input type="submit" value="update" name="button_type"></td>

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
