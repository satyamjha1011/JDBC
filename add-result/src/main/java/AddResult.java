

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddResult extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		// request.getParameter("id") -> gives me the id in the string formate
		// we are converting id from string to integer by using pasreInt()
		
		String name = request.getParameter("name");
		//name is required in the string formate Therefore we are not converting it into an int.
		
		int marks1 = Integer.parseInt(request.getParameter("marks1"));
		int marks2 = Integer.parseInt(request.getParameter("marks2"));
		int marks3 = Integer.parseInt(request.getParameter("marks3"));
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024", "root", "satyam");
			String s = "insert into student value (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setInt(1, id);
			pstmt.setNString(2, name);
			pstmt.setInt(3, marks1);
			pstmt.setInt(4, marks2);
			pstmt.setInt(5, marks3);
			int rows = pstmt.executeUpdate();
			PrintWriter out = response.getWriter();
			if(rows==0) {
				out.println("Student data not found");
			}
			else {
				out.println("Student data added Successfully");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
