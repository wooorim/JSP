<%@page import="edu.global.ex.java.Circle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 자바 문법을 사용하기위한 선언(스크립트릿 문법) -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String radius = request.getParameter("radius");
		Circle circle = new Circle(Double.valueOf(radius));
	%>
	반지름 <%= radius%><br>
	넓이 <%= circle.getArea() %><br>
</body>
</html>