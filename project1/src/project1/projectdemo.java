package project1;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.util.Scanner;


	public class projectdemo {
		public static void main(String[] args) throws SQLException {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			System.out.println("Drivers loaded successfully");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root","satyam");
			System.out.println("Connection established");
			String s = "insert into user value(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(s);
			Scanner scane = new Scanner(System.in);
			
			
			System.out.println("Enter the name");
			String name =scane.next();
			System.out.println("Enter the user_name");
			String user_name =scane.next();
			System.out.println("Enter the password ");
			String password =scane.next();
			System.out.println("Enter the email");
			String email =scane.next();
		
			
			pstmt.setString(1, name);
			pstmt.setString(2, user_name);
			pstmt.setString(3, password);
			pstmt.setString(4, email);
			
			
			int rows = pstmt.executeUpdate();
			System.out.println(rows);
			scane.close();
		}
	}

