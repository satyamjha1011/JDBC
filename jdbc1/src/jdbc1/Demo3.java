//Program for inserting data into the student table 

package jdbc1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class Demo3 {
	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Drivers loaded successfully");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root","satyam");
		System.out.println("Connection established");
		String s = "insert into student value(?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(s);
		Scanner scane = new Scanner(System.in);
		System.out.println("Enter the id");
		int id = scane.nextInt();
		System.out.println("Enter the name");
		String name =scane.next();
		System.out.println("Enter the marks1");
		int marks1 = scane.nextInt();
		System.out.println("Enter the marks2");
		int marks2 = scane.nextInt();
		System.out.println("Enter the marks3");
		int marks3 = scane.nextInt();
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setInt(3, marks1);
		pstmt.setInt(4, marks2);
		pstmt.setInt(5, marks3);
		int rows = pstmt.executeUpdate();
		System.out.println(rows);
		scane.close();
	}
}

