<%@page import="edu.global.ex.vo.EmpVO"%>
<%@page import="java.util.List"%>
<%@page import="edu.global.ex.vo.EmpDAO"%>
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
		EmpDAO dao = new EmpDAO();
		List<EmpVO> vos = dao.empSelect();
		
		for(EmpVO vo : vos){
			out.print("사원번호: " + vo.getEmpno() + "<br>");
			out.print("사원이름: " + vo.getEname() + "<br>");
			out.print("직업: " + vo.getJob() + "<br>");
			out.print("메니져번호: " + vo.getMgr() + "<br>");
			out.print("입사날짜: " + vo.getHiredate() + "<br>");
			out.print("월급: " + vo.getSal() + "<br>");
			out.print("보너스: " + vo.getComm() + "<br>");
			out.print("부서번호: " + vo.getDeptno() + "<br>");
			out.print("<hr>");
		}
	%>
</body>
</html>