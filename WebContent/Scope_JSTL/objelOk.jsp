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
		String id = request.getParameter("id"); //submit버튼은 누르면 id, pw정보 넘어온다 -> request객체로 받음
		String pw = request.getParameter("pw");
	%>

	아이디 :<%=id %><br> 
	패스워드 :<%=pw %><br>

	<hr>

	applicationScope : ${ applicationScope.application_name }<br /> <!-- 값 출력 --> 
	sessionScope : ${ sessionScope.session_name }<br /> <!-- 값 출력 --> 
	pageScope : ${ pageScope.page_name }<br /> <!-- 값 출력 = 출력 안됨 --> 
	requestScope : ${ requestScope.request_name } <!-- 값 출력 = 출력 안됨 -->

</body>
</html>