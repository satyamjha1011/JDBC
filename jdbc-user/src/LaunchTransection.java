import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class LaunchTransection {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());	
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024", "root", "satyam");
		Scanner scan = new Scanner(System.in);
		con.setAutoCommit(false);
		String s1 = "insert into student values (?,?,?,?,?)";
		PreparedStatement pstmt2 = con.prepareStatement(s1);
		System.out.println("Enter id");
		int id2 = scan.nextInt();
		System.out.println("Emter the name");
		String name = scan.next();
		System.out.println("marks1");
		int marks1 = scan.nextInt();
		System.out.println("marks2");
		int marks2 = scan.nextInt();
		System.out.println("marks3");
		int marks3 = scan.nextInt();
		pstmt2.setInt(1, id2);
		pstmt2.setString(2, name);
		pstmt2.setInt(3,marks1);
		pstmt2.setInt(4,marks2);
		pstmt2.setInt(5,marks3);
		
		pstmt2.executeUpdate();
		con.commit();

	}

}
