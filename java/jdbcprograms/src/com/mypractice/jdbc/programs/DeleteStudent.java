package com.mypractice.jdbc.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class DeleteStudent {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
				PreparedStatement pstm = conn.prepareStatement("delete from STUDENT where sno = ?")) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int sno = Integer.parseInt(br.readLine());
			pstm.setInt(1, sno);
			int row  = pstm.executeUpdate();
			System.out.println(row +"record deleted");

		}
	}
}
