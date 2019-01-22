<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<script language='javascript'>
	function showprint() {
		frames.focus();
		frames.print();
	}
	function myFunction() {
		var txt;
		var r = confirm("Press ok to logout or Press cancel for saty here!");
		if (r == true) {
			alert("Logout Successfully !!!!");
			document.getElementById("myForm").submit();

		} else {
			alert("Continue.....");
		}
		document.getElementById("demo").innerHTML = txt;
	}
</script>
<div align="right">
	<font color="red" align="right" size="4"> <%
 	String name = (String) session.getAttribute("name");
 	if (name != null) {
 		out.print("User:" + "\t" + name);
 	} else {
 		response.sendRedirect("index.jsp");
 	}
 %>
	</font>
</div>
<body>
	<b><a href="search.jsp">Go Back to Search Page </a></b>
	<form name='f'>
		<center>
			<h2>
				<u> Search based on ${requestScope.searchParam} </u>
			</h2>
		</center>
		<br>
		<c:choose>
			<c:when test="${requestScope.list ne null}">

				<table border="1" width="100%">
					<tr>
						<th>BookId</th>
						<th>BookName</th>
						<th>AuthorName</th>
						<th>Category</th>
						<th>Status</th>
					</tr>

					<c:forEach var="book" items="${requestScope.list}">
						<tr>
							<td><c:out value="${book.bookId}" /></td>
							<td><c:out value="${book.bookName}" /></td>
							<td><c:out value="${book.authorName}" /></td>
							<td><c:out value="${book.category}" /></td>
							<td><c:out value="${book.status}" /></td>
						</tr>
					</c:forEach>
					</c:when>
					</c:choose>
				</table>
				<br>
				<br>
				<br>
				<center>
					<b>The Above Table Gives you the Data Search done by You :-)</b>
				</center>
	</form>
	<form action="./logout" method="post" id="myForm">
		<input type="button" value="logout" onclick="myFunction()">
	</form>
</body>
</html>
