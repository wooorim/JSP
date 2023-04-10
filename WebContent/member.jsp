<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보조회</title>
</head>
<body>
<%@ include file="topmenu.jsp" %>

<div class="title">회원정보조회</div>
	<div class="wrapper">
	   <table width="600" height="300" cellpadding="0" cellspacing="0" border="1">
      <tr>
         <td>수강월</td>
         <td>회원번호</td>
         <td>회원명</td>
         <td>강의명</td>
         <td>강의장소</td>
         <td>수강료</td>
         <td>등급</td>
      </tr>
      <c:forEach var="member" items="${members}">
      <tr>
         <td>${member.regist_month}</td>
         <td>${member.c_no}</td>
         <td>${member.c_name}</td>
         <td>${member.class_name}</td>
         <td>${member.class_area}</td>
         <td>${member.tuition}</td>
         <td>${member.grade}</td>
      </tr>
      </c:forEach>
   </table>
   </div>
   <%@ include file="footer.jsp" %>
</body>
</html>