<%@page import="edu_mwr_ex_java.Grade"%>
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
		String getKor = request.getParameter("kor");
		String getEng = request.getParameter("eng");
		String getMath = request.getParameter("math");
		
		int kor = Integer.valueOf(getKor);
		int eng = Integer.valueOf(getEng);
		int math = Integer.valueOf(getMath);
		
		Grade grade = new Grade(kor,eng,math);
		
	%>
</body>
</html>