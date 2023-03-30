<%@page import="edu.global.ex.vo.DeptVO"%>
<%@page import="java.util.List"%>
<%@page import="edu.global.ex.vo.DeptDAO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<!-- sql로 import해준다 -->
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
		DeptDAO dao = new DeptDAO(); //반복해서 사용하는것은 객체화 시켜놓아야된다
		List<DeptVO> vos = dao.deptSelect();

		for (DeptVO vo : vos) {
			out.print("부선번호: " + vo.getDeptno() + "</br>");
			out.print("장소: " + vo.getLoc() + "</br>");
			out.print("부서이름: " + vo.getDname() + "</br>");
			out.print("<hr>");

		}
	%>
</body>
</html>