<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
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
 %> <%
 	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
 	response.setHeader("Pragma", "no-cache");
 	response.setDateHeader("Expires", 0);
 %>


			<form action="./logout" method="post" id="myForm">
				<input type="button" value="logout" onclick="myFunction()">
			</form>

		</font>
	</div>
	<span style="filter: shadow(color = pink, direction = 135)"> <font
		color=#F4743B size=8><b>
				<center>Welcome Admin to BookStore Portal</center>
		</b></font>
		<hr color=orange width=90%>
	</span>

	<table border=0 align=center cellspacing="50">
		<tr align=left>
			<th rowspan=1><img src="insert.png" height="100px" width="120px"></th>
			<th colspan=1><img src="update.png" height="100px" width="120px"></th>
			<th colspan=1><img src="delete.jpg" height="110px" width="120px"></th>
		<tr align=center>
		</tr>

		<tr>

			<td>
				<form action="/BookApplication/insert.jsp">
					<input type="submit" value="INSERT">
				</form>
			</td>

			<td>
				<form action="/BookApplication/update.jsp">
					<input type="submit" value="UPDATE">
				</form>
			</td>

			<td>
				<form action="/BookApplication/delete.jsp">
					<input type="submit" value="DELETE">
				</form>
			</td>


		</tr>
	</table>



</body>
</html>