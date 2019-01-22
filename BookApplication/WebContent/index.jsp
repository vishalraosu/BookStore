<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<style>
table {
	border-collapse: collapse;
	position: fixed;
	top: 30px;
	right: 90px;
	width: 30px;
	height: 30px;
}

table, td, th {
	border: 1px solid black;
}

.heading {float
	
}

.options {
	float: right;
}
</style>


	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
	%>

<body bgcolor="#483C46">
	<div class="heading">
		<form name=f action="AdminLogin.jsp" method="post">

			<span style="filter: shadow(color = pink, direction = 135)"> <font
				color=#F4743B size=30><b>Welcome to Book Store <b></b></font>
				<hr color=#BEEE62 width=100%>
			</span>
			<div class="options">
				<table border=1 bgcolor='#BEEE62'>
					<tr>
						<th><input type='submit' value='Admin' name="admin"></th>
						<th><input type='submit' value='User' name="user"
							formaction="UserPage.jsp"></th>

					</tr>
				</table>

			</div>
		</form>
	</div>
	<div>
		<img alt="image not found" src="firstbookpic.jpg" height="600px"
			width="100%">
	</div>
</html>