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

	for(int i = 1; i <= 9; i++){
		out.println("=====" + i + "단" + "=====<br />");
		for(int j = 1; j <= 9; j++){
		out.println(i + " * " + j + " = " + (i * j) + "<br>");
		
		//System.out.println(i + " * " + j + " = " + (i * j)); System은 콘솔 창에 출력된다.
		}
		out.println("<hr>");
	}
	%>
	
	<%! //!붙이면 변수 선언, 함수를 메모리에 올린다.
	 int i =10;
	String str = "abc";
	
	private int sum(int a, int b){
		return a + b;
	}
	%>
	
	<%out.println("<hr>"); %>
	<%= i%><br><!-- =붙이면 out.println()기능, 위의 코드와 같은 기능 -->
	<%= str %><br>
	<%= sum(1,5) %>
</body>
</html>