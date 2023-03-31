<%@page import="edu.global.ex.vo.EmpDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.global.ex.vo.EmpVO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		out.println("AAA");
	%>
	<%="AAA"%>
	${"AAA"}

	<!-- 출력 태그 -->
	<c:out value="c:out태그 출력문을 만드는 태그" />
	<br>
	<c:out value="hello word" />
	<!-- c: JSTL문법 -->

	<c:out value="hello" />
	<br>
	<c:out value='${ "안녕하세요" }' />
	<br>
	<!-- JSTL문법안에 EL문법 삽입 가능 -->

	<!-- 변수 선언 태그 -->
	<c:set var="name1" value="c:set태그 변수를 다룰 때 사용. 변수선언."></c:set>
	${ name1 }
	<br>
	<c:set var="name2" value="홍길동"></c:set>
	<c:set var="name3" value="홍길순"></c:set>
	${ name2 }
	<br> ${ name3 }
	<br>

	<%
		pageContext.setAttribute("name2", "바뀔까");
	%>
	<!-- 자기자신의 servlet페이지에 저장되어있는 변수 변경 -->
	${ name2 }
	<br>

	<!-- 삭제 태그 -->
	<c:remove var="name2" />
	<hr>
	${ name2 }
	<br> ${ name3 }
	<br>

	<!-- if문 -->
	<c:if test="${ 10 > 20 }" var="result1">
		10은 20보다 크다.<br>
	</c:if>
	result1 : ${ result1 }
	<br>

	<c:if test="${ 10 < 20 }" var="result2">
		20은 10보다 크다.<br>
	</c:if>
	result2 : ${ result2 }
	<br>

	<hr>

	<c:set var="user" value="abcd123" />
	<!-- else if문, else문 -->
	<c:choose>
		<c:when test="${ user=='admin' }">
			관리자 페이지
		</c:when>
		<c:otherwise>
			${ user }님 반갑습니다.
		</c:otherwise>
	</c:choose>
	<hr>

	<%-- ${el}문법은 메모리에 올라간 걸 사용할 때 쓴다. --%>
	<!-- foreach문 -->
	<%
		pageContext.setAttribute("numList", new String[] { "1", "2", "3", "4", "5" });
	%>
	<ul>
		<c:forEach var="num" items="${numList}">
			<li>${num}</li>
		</c:forEach>
	</ul>

	<%
		List<String> fruits = new ArrayList<>();
		fruits.add("apple");
		fruits.add("banana");
		fruits.add("pineapple");
		fruits.add("kiwi");
		fruits.add("melon");
		pageContext.setAttribute("fruits", fruits); //키 value값
	%>

	<ul>
		<c:forEach var="fruit" items="${fruits}">
			<li>${fruit}</li>
		</c:forEach>
	</ul>

	<%
		EmpDAO dao = new EmpDAO();
		List<EmpVO> emps = dao.empSelect();

		pageContext.setAttribute("emps", emps);
	%>

	<ul>
		<c:forEach var="emp" items="${emps}">
			<li>${emp.ename}</li>
		</c:forEach>
	</ul>
	
	
	<c:forEach var="i" begin="2" end="9"> 
			<c:out value="${i}단"/><br>
		<c:forEach var="j" begin="1" end="9">
			<c:out value="${i} x ${j} = ${ i * j }"/><br>
		</c:forEach>
			<hr>
	</c:forEach>
	
	<table border="1">
		<c:forEach var="i" begin="1" end="9">
		<tr>
			<c:forEach var="j" begin="2" end="9">
			<td>${ j } x ${ i } = ${i *j}</td>
			</c:forEach>
		</tr>
		</c:forEach>
	</table>
		
	</table>
	
</body>
</html>