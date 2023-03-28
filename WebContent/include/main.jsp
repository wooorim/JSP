<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메인 페이지입니다.</h1>
	<% //디버깅 방법
		System.out.println("중간 태그");
	%>
	<script> //디버깅 방법
		console.log("콘솔 태그");
	</script>
	
	<jsp:forward page="sub.jsp" />
	<!-- 요기에서 실행을 멈추고 sub.jsp페이지로 전환 -->
	<script>
		console.log("콘솔 태그");
	</script>
	
	<h1>꼬리말 입니다.</h1>
	<script>
		console.log("콘솔 태그");
	</script>
</body>
</html>