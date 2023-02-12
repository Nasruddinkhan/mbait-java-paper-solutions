package com.mypractice.jdbc.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Student {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
				PreparedStatement pstm = conn.prepareStatement("insert into STUDENT values(?, ?, ?, ?, ?)")) {
			     BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
			     int sno =		 Integer.parseInt(br.readLine());
			     String name = br.readLine();
			     double total = Double.parseDouble(br.readLine());
			     double avg = Double.parseDouble(br.readLine());
			     String result = br.readLine();
			     pstm.setInt(1, sno);
			     pstm.setString(2, name);
			     pstm.setDouble(3,total);
			     pstm.setDouble(4,avg);
			     pstm.setString(5, result);
			     int row  = pstm.executeUpdate();
			     if (row > 0)
			     System.out.println(row +" record insert successfully");
			     
				
		}
	}
}