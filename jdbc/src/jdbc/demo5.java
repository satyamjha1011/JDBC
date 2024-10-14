package jdbc;
import java.sql.Connection;

public class demo5 {

	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Driver loaded Successfully");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024", "root", "satyam");
		System.out.println("Connection established successfully");
		
		String s = "delete from student where id=?";
		PreparedStatement pstmt = con.prepareStatement(s);
		Scanner scane = new Scanner(System.in);
		System.out.println("Enter the id");
		int id = scane.nextInt();
		
	
		pstmt.setInt(2, id);
		
		int rows = pstmt.executeUpdate();
		System.out.println(rows);
	}
}

