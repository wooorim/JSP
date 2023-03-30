<%-- <%@page import="edu.global.ex.vo.EmpVO"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="empVO" class="edu.global.ex.vo.EmpVO"/>
<jsp:setProperty name="empVO" property="ename" value="홍길동"/>
<%-- <% 위의 <jsp:useBean><jsp:setProperty>문으로 대치 가능
	EmpVO vo = new EmpVO(); //객체 생성
	vo.setEname("홍길동");
%> --%>
 <!-- 객체 생성 방법 (EL문법)-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 스크립트릿 문법 -->
	<% 
	out.println("1");
	%>
	
	<!-- 명칭 : Expression -->
	<%= 1%> 
	
	
	<!-- EL문법안에는 간단한 연산, 삼항 연산자도 선언할 수 있다. -->
	${1}<br> <!-- EL(Expression Language)문법 -->
	${1+1}<br>
	${2-3}<br>
	${4*5}<br>
	${6/7}<br>
	
	<!-- 삼항 연산자 -->
	${(1>2) ? 1:2}<br>
	${(1>2) || (1<2)}<br>
	
	<!-- 데이터 타입은 가리지 않고 들어갈 수 있다. -->
	${10}<br>
	${99.99}<br>
	${"ABC"}<br>
	${true}<br>
	
	${ empVO.ename }<br>
	
</body>
</html>