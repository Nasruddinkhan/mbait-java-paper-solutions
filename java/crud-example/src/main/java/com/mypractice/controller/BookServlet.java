package com.mypractice.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String bookname = request.getParameter("bookname");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
			PreparedStatement stmt = conn.prepareStatement("select * from book where ISBN = ?");
			stmt.setString(1, bookname);
			ResultSet rs = stmt.executeQuery();
			StringBuilder sb = new StringBuilder();
			sb.append("<table border='1'>");
			sb.append("<tr>");
			sb.append("<th>").append("AUTHOR Name").append("</th>");
			sb.append("<th>").append("DESCRIPTION").append("</th>");
			sb.append("<th>").append("TITLE").append("</th>");
			sb.append("</tr>");
			while (rs.next()) {
				String author = rs.getString("AUTHOR");
				String description = rs.getString("DESCRIPTION");
				String title = rs.getString("TITLE");
				
				sb.append("<tr>");
				sb.append("<td>").append(author).append("</td>");
				sb.append("<td>").append(description).append("</td>");
				sb.append("<td>").append(title).append("</td>");
				sb.append("</tr>");
			}
			sb.append("</table>");
			response.getWriter().append(sb);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
