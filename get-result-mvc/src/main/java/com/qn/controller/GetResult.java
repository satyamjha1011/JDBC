package com.qn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qn.model.Student;

public class GetResult extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Student s = new Student();
		s.setId(id);
		s.getResult();
		id= s.getId();
		String name = s.getName();
		int marks1 = s.getMarks1();
		int marks2 = s.getMarks2();
		int marks3 = s.getMarks3();
		
		HttpSession session = request.getSession(true);
		session.setAttribute("sid", id);//sid=id;
		session.setAttribute("sname", name);
		session.setAttribute("smarks1", marks1);
		session.setAttribute("smarks2", marks2);
		session.setAttribute("smarks3", marks3);
		response.sendRedirect("/get-result-mvc/getResultSuccesss.jsp");
	}
}