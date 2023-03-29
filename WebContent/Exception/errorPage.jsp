<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page isErrorPage="true" %>
	<%-- <% response.setStatus(200); %> --%> <!-- 에러가 발생 시  강제로 개발자가 정한 Status번호로 응답-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	죄송합니다. Error.<br />
	<%= exception.getMessage() %> <!--  -->
</body>
</html>