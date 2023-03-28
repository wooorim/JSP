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
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(60); //setMaxAge()시간 지정 함수. 60분간 쿠키 저장.

			response.addCookie(cookie); //상대방 웹 브라우저 안에 쿠키 넣음(추가).
			response.sendRedirect("welcome.jsp"); //redirect는 유저로 하여금 다시 welcome.jsp로 접속하게 하는 거.
			//sendRedirect()
			
		} else {
			response.sendRedirect("login.jsp");
		}
	%>
</body>
</html>