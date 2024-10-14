//Program for updating data into the student table 

package jdbc1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Demo4 {
	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Driver loaded Successfully");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024", "root", "satyam");
	System.out.println("Connection established successfully");
		
		String s = "update student set name=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(s);
		Scanner scane = new Scanner(System.in);
		System.out.println("Enter the name");
		String name= scane.next();
		System.out.println("Enter the id");
		int id = scane.nextInt();
		
		pstmt.setString(1, name);
		pstmt.setInt(2, id);
		
		int rows = pstmt.executeUpdate();
		System.out.println(rows);
		scane.close();
	}
}

