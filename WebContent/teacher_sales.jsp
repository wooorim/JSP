<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강사매출현황</title>
</head>
<%@ include file="topmenu.jsp" %>

<div class="title">강사매출현황</div>
	<div class="wrapper">
<body>
	   <table width="600" height="300" cellpadding="0" cellspacing="0" border="1">
      <tr>
         <td>강사코드</td>
         <td>강의명</td>
         <td>강사명</td>
         <td>총매출</td>
      </tr>
      <c:forEach var="sale" items="${sales}">
      <tr>
         <td>${sale.teacher_code}</td>
         <td>${sale.class_name}</td>
         <td>${sale.teacher_name}</td>
         <td>${sale.tuition}</td>
      </tr>
      </c:forEach>
   </table>
   <%@ include file="footer.jsp" %>
</body>
</html>