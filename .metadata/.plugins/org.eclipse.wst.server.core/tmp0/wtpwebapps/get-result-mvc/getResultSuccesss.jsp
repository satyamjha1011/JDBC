<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Integer id = (Integer)session.getAttribute("sid");
String name = (String)session.getAttribute("sname");
Integer marks1 = (Integer)session.getAttribute("smarks1");
Integer marks2 = (Integer)session.getAttribute("smarks2");
Integer marks3 = (Integer)session.getAttribute("smarks3");
out.println(id + "  " + name + "  " + marks1 + "  " + marks2 + "  " + marks3);
%>
</body>
</html>