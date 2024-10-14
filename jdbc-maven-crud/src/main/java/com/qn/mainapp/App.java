package com.qn.mainapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) throws Exception  {
    	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Drivers loaded successfully");
		Connection con =DriverManager.getConnection("jdbc:mysql://"+ "localhost:3306/june_2024","root","satyam");
		System.out.println("Connection established");
		String s = "select * from Student where id=?";
		PreparedStatement pstmt = con.prepareStatement(s);
		System.out.println("ENTER THE ID");
		Scanner scan = new Scanner(System.in);
		int id = scan.nextInt();
		pstmt.setInt(1, id);
		ResultSet res = pstmt.executeQuery();
		if(res.next()) {
			id= res.getInt(1);
			String name = res.getString(2);
			int marks1 = res.getInt(3);
			int marks2 = res.getInt(4);
			int marks3 = res.getInt(5);
			System.out.println(id+" "+name+" "+marks1+" "+marks2+" "+marks3+" ");
		}
		else {
			System.out.println("Invalid id");
			
		}
		scan.close();
	}
	
    }

