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
	int i = 0;
	while(true){
		i++;
		out.println("2 * " + i + " = " + (2 * i) + "</br>");
	
		out.println("=========<br />");
		
	if(i >= 9)
		break;
	}
	%>
</body>
</html>