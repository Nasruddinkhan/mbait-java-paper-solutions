package com.mypractice.jdbc.programs;

import java.sql.*;

public class GetEmployee {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
				PreparedStatement pstm = conn.prepareStatement("select empid, empname, edept, total_sal from employees")) {
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("empid")+ " | " + rs.getString("empname")+ " | " + rs.getString("edept")+ " | " + rs.getString("total_sal"));
			}

		}
	}
}
