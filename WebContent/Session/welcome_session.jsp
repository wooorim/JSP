<%@page import="java.util.Enumeration"%>
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
	<%
		String id = (String) session.getAttribute("id");
		String pw = (String) session.getAttribute("pw");
		//session객체는 Object타입이여서 형 변황을 해준다.
	%>
	환영합니다 :
	<%=id%>님
	<br> 당신의 PASSWORD :
	<%=pw%>
	<br>
	<hr>

	<!-- session객체에 담겨있는 정보 확인 출력 -->
	<%
		Enumeration enumeration = session.getAttributeNames();
		while (enumeration.hasMoreElements()) {
			String sName = enumeration.nextElement().toString();
			String sValue = (String) session.getAttribute(sName);

			out.print(sName + ":" + sValue + "<br>");
		}

		out.println("==================<br/>");
		//세션 특정 데이터 삭제
		session.removeAttribute("pw");

		//삭제 후 다시 enumeration객체를 가져와서 선언해줘야 갱신된 내용이 출력됨
		enumeration = session.getAttributeNames();

		while (enumeration.hasMoreElements()) {
			String sName = enumeration.nextElement().toString();
			String sValue = (String) session.getAttribute(sName);

			out.print(sName + ":" + sValue + "<br>");
		}

		out.println("==================<br/>");
		//모든 데이터 삭제 -> 세션 날림
		session.invalidate();

		// 유효한 세션 아이디 존재 여부
		if (request.isRequestedSessionIdValid()) {
			out.print("session valid");
		} else {
			out.print("session Invalid");
		}
	%>
</body>
</html>