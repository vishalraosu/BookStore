<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.softvision.sessionHandler.LogoutServlet"%>
<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	String param = request.getParameter("first");
	System.out.println("searh page======" + param);
	if (param == null) {
		System.out.println("searh IF CON======" + param);
		response.sendRedirect("index.jsp");
	}
%>
<html>
<script language="javascript">
	function isHtml() {
		f.source.value = "Html";
		validate();
	}

	function isExcel() {
		f.source.value = "Excel";
		validate();
	}

	function validate() {
		if (f.searchParam.selectIndex == '0') {
			alert("You should select the option !!!");
			f.searchParam.focus();
			return false;
		}
		if (f.searchValue.value == "") {
			alert("You should provide data!!!");
			f.searchParam.focus();
			return false;
		}

		else {
			f.submit();
			return true;
		}
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
<body>
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
		<form action="./logout" method="post" id="myForm">
			<input type="button" value="logout" onclick="myFunction()">
		</form>
	</div>
	<form name=f action="/BookApplication/searchBook" method="post">
		<center>
			<span style="filter: shadow(color = pink, direction = 135)"> <font
				color=#F4743B size=8><b>Search for Books</b></font>
				<hr color=orange width=50%>
			</span>
		</center>

		<table border=1 cellpadding=4 cellspacing=4 align=center
			bgcolor='#BEEE62'>
			<tr>
				<th>Search By</th>
				<th><select name='searchParam'>
						<option selected value=''>Select a value</option>
						<option value='BOOK_ID'>BOOK_ID </option>
						<option value='BOOK_NAME'>BOOK_NAME</option>
						<option value='AUTHOR_NAME'>AUTHOR_NAME</option>
						<option lable='CATEGORY'>CATEGORY</option>
						<option value='STATUS'>STATUS</option>

				</select></th>
				<td colspan="2">Enter the Data to Search:<input type="text"
					name="searchValue"></td>
			</tr>
			<tr>
				<td colspan="5" align="center"><input type='button'
					value='Html Output' onClick='isHtml()'> <input
					type='button' value='Excel Output' onClick='isExcel()'></td>
			</tr>
		</table>
		<input type='text' name='source' readonly style='visibility: hidden'>
	</form>


</body>
</html>
