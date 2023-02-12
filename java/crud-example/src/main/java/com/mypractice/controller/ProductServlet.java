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
			ResultSet resultSet = stmt.executeQuery();
			StringBuilder sb = new StringBuilder();
			sb.append("<table border='1' >");
			sb.append("<tr><th>Product Name</th><th>Price</th><th>Quantity</th><th>Total Cost</th></tr>");
			double totalCost = 0;
			while (resultSet.next()) {
				double price = resultSet.getDouble("price");
				int quantity = resultSet.getInt("quantity");
				double productCost = price * quantity;
				totalCost += productCost;
				sb.append("<tr><td>").append(resultSet.getString("name")).append("</td>");
				sb.append("<td>").append(price).append("</td>");
				sb.append("<td>").append(quantity).append("</td>");
				sb.append("<td>").append(productCost).append("</td></tr>");
			}
			sb.append("<tr><td colspan='3'>Total Cost</td><td>").append(totalCost).append("</td></tr>");
			sb.append("</table>");
			response.getWriter().append(sb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
