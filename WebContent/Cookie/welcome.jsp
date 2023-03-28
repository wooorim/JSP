<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome jsp 입니다.</h1>
	<!-- 쿠키 확인 -->
	<%
		Cookie[] cookies = request.getCookies();
	
	for(int i = 0; i < cookies.length; i++){
		out.println(cookies[i].getValue() + "<br>");
	}
	
	%>
</body>
</html>