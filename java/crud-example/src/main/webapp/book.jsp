<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Details</title>
</head>
<body>
	<form action="book.jsp" method="post">
		<input type="text" name="bookName" />
		<button type="submit">Search</button>
	</form>
	<%
	String bookName = request.getParameter("bookName");
	if (bookName != null) {
	%>
	<%
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
		PreparedStatement pstm = conn.prepareStatement("select * from book where ISBN = ?");
		pstm.setString(1, bookName);
		ResultSet rs = pstm.executeQuery();
	%>
	<table border="1">
		<tr>
			<th>Author</th>
			<th>Description</th>
			<th>Title</th>

		</tr>

		<%
		if (rs.next()) {
		%>
		<tr>
			<td><%=rs.getString("author")%></td>
			<td><%=rs.getString("description")%></td>
			<td><%=rs.getString("title")%></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	rs.close();
	pstm.close();
	conn.close();
	} 
	catch (Exception e) {
		e.printStackTrace();
		}
	}
	%>

</body>
</html>