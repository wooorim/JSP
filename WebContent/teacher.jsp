<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강사조회</title>
</head>
<body>
<%@ include file="topmenu.jsp" %>

<div class="title">강사조회</div>
	<div class="wrapper">
	   <table width="600" height="300" cellpadding="0" cellspacing="0" border="1">
      <tr>
         <td>강사코드</td>
         <td>강사명</td>
         <td>강의명</td>
         <td>수강료</td>
         <td>강사자격취득일</td>
      </tr>
      <c:forEach var="teacher" items="${teachers}">
      <tr>
         <td>${teacher.teacher_code}</td>
         <td>${teacher.teacher_name}</td>
         <td>${teacher.class_name}</td>
         <td>${teacher.class_price}</td>
         <td>${teacher.teacher_regist_date}</td>
      </tr>
      </c:forEach>
   </table>
   </div>
   <%@ include file="footer.jsp" %>
</body>
</html>