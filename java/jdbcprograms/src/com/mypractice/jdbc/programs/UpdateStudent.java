package com.mypractice.jdbc.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateStudent {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
				PreparedStatement pstm = conn.prepareStatement("update STUDENT set sname  = ?, total = ?, avg = ?, result = ? where sno = ?")) {
			     BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
			     int sno =		 Integer.parseInt(br.readLine());
			     String name = br.readLine();
			     double total = Double.parseDouble(br.readLine());
			     double avg = Double.parseDouble(br.readLine());
			     String result = br.readLine();
			     
			     pstm.setString(1, name);
			     pstm.setDouble(2,total);
			     pstm.setDouble(3,avg);
			     pstm.setString(4, result);
			     pstm.setInt(5, sno);
			     int row  = pstm.executeUpdate();
			    
			     System.out.println(row +" record update successfully");
			     
				
		}
	}
}