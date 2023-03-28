<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!String id, pw;%>
	<%
		id = request.getParameter("id");
		pw = request.getParameter("pw");

		if (id.equals("abcd") && pw.equals("1234")) {
			
			session.setAttribute("id", id); //내장 객체. new해서 생성안해도 기본적으로 제공되는 객체.
			//("id"=키 , id=value) -> 키, value형태로 저장된다.
			session.setAttribute("pw", pw);
			response.sendRedirect("welcome_session.jsp"); //redirect는 유저로 하여금 다시 welcome.jsp로 접속하게 하는 거.
			
			
		} else {
			response.sendRedirect("login.jsp");
		}
	%>
</body>
</html>