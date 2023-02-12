package com.mypractice.jdbc.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetStudent {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
				PreparedStatement pstm = conn.prepareStatement("select clgId, clgname, coursename from courses where coursename = 'MBA-IT'")) {
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("clgId")+ " | " + rs.getString("clgname")+ " | " + rs.getString("coursename"));
			}

		}
	}
}
