<%@page import="java.util.ArrayList,com.softvision.BO.BookBO"
	isELIgnored="false"%>
<%
	response.addHeader("Content-Disposition","attachment;filename=Title1.xls");
	response.setContentType("application/ms-excel");
	ArrayList<BookBO> al = (ArrayList<BookBO>) request.getAttribute("list");
	String cat = (String) request.getAttribute("searchParam");
%>

<center>
	<h2>
		<u> Search based on <%=cat.toUpperCase()%> </u>
	</h2>
</center>
<br>

<table border="1" width="100%">
	<tr>
		<th>Sno</th>
		<th>BookId</th>
		<th>BookName</th>
		<th>AuthorName</th>
		<th>Category</th>
		<th>Status</th>
	</tr>
	<%
		for (int i = 0; i < al.size(); i++) {
			BookBO sb = (BookBO) al.get(i);
	%>
	<tr>
		<td><%=(i + 1)%></td>
		<td><%=sb.getBookId()%></td>
		<td><%=sb.getBookName()%></td>
		<td><%=sb.getAuthorName()%></td>
		<td><%=sb.getCategory()%></td>
		<td><%=sb.getStatus()%></td>
	</tr>
	<%
		}
	%>
</table>