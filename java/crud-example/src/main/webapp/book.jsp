<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.sql.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Details</title>
</head>
<body>
	<h3>Enter Book Name:</h3>
	<form action="book.jsp" method="post">
		<input type="text" name="bookName" /> <input type="submit"
			value="Submit" />
	</form>
	<%
    String bookName = request.getParameter("bookName");
    if (bookName != null) {
    	try {
    	Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM product where name = ?");
		pstmt.setString(1, bookName);
        ResultSet rs  = pstmt.executeQuery();
        if (rs.next()) {
  %>
	<h3>Book Details:</h3>
	<table border="1">
		<tr>
			<td>Product Name</td>
			<td><%= rs.getString("NAME") %></td>
		</tr>
		<tr>
			<td>Price</td>
			<td><%= rs.getString("PRICE") %></td>
		</tr>
		<tr>
			<td>Quantity</td>
			<td><%= rs.getInt("QUANTITY") %></td>
		</tr>

	</table>
	<%
        } else {
  %>
	<p>
		No book found with the name "<%= bookName %>".
	</p>
	<%
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  %>
</body>
</html>