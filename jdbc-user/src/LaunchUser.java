import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LaunchUser {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("1 Register");
		System.out.println("2 login");
		System.out.println("Enter your choice ");
		int choice = scan.nextInt();
		switch(choice) {
		case 1: register();
		break;
		case 2:login();
		break;
		default :System.out.println("invalid Choice");
		}
		
	}

	 static void login() throws Exception {
		// TODO Auto-generated method stub
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root", "satyam");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the user_name");
		String user_name = scan.next();
		System.out.println("Enter the Password");
		String Password = scan.next();
		String s = "select * from user where user_name=?";
		PreparedStatement pstmt = con.prepareStatement(s);
		pstmt.setString(1, user_name);
		ResultSet res = pstmt.executeQuery();
		if (res.next()) {
			if  (Password.equals(res.getString(3)))  {
				System.out.println("Login Successful");
			} else {
				System.out.println("invalid Password");
			}
		} else {
			System.out.println("invalid user_name");
		}
	}

	static void register() throws Exception {
		 DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root","satyam");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter name");
		String name = scan.next();
		System.out.println("Enter user_name");
		String username = scan.next();
		
		while(true) {
			String s = "select * from user where user_name=?";
			 PreparedStatement pstmt =con.prepareStatement(s);
			 pstmt.setString(1, username);
			 ResultSet res = pstmt.executeQuery();
			 
			 if(res.next()) {
				 System.out.println("User_name already exists please enter another user_name");
				 username=scan.next();
			 }
			 else {
				 break;
			 }
		}
		
		String password;
		String confirmPassword;
		do {
		System.out.println("Enter password ");
		 password = scan.next();
		System.out.println("Enter confirm password");
		 confirmPassword = scan.next();
		}while(!password.equals(confirmPassword));
		System.out.println("Enter email");
		String email = scan.next();
		String s2= "insert into user values(?,?,?,?)";
		PreparedStatement pstmt1= con.prepareStatement(s2);
		pstmt1.setString(1, name);
		pstmt1.setString(2, username);
		pstmt1.setString(3, password);
		pstmt1.setString(4, email);
		pstmt1.executeUpdate();
		
	}

}
