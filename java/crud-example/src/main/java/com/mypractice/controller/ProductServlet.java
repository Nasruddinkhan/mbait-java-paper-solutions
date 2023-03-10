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

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM product");
			ResultSet rs = stmt.executeQuery();
			StringBuilder sb = new StringBuilder();
			sb.append("<table border='1'>");
			sb.append("<tr>");
			sb.append("<th>").append("Product Name").append("</th>");
			sb.append("<th>").append("Quantity").append("</th>");
			sb.append("<th>").append("Price").append("</th>");
			sb.append("<th>").append("Product Cost").append("</th>");
			sb.append("</tr>");
			int total = 0;
			while (rs.next()) {
				String name = rs.getString("NAME");
				int price = rs.getInt("PRICE");
				int quantity = rs.getInt("QUANTITY");
				int productCost = price * quantity;
				total = total + productCost;
				sb.append("<tr>");
				sb.append("<td>").append(name).append("</td>");
				sb.append("<td>").append(price).append("</td>");
				sb.append("<td>").append(quantity).append("</td>");
				sb.append("<td>").append(productCost).append("</td>");
				sb.append("</tr>");
			}
			sb.append("<tr>");
			sb.append("<td colspan='2'>").append("Total Cost").append("</td>");
			sb.append("<td colspan='2'>").append(total).append("</td>");
			sb.append("</tr>");
			sb.append("</table>");
			response.getWriter().append(sb);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
