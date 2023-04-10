<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강신청</title>
<script src="sports.js"></script>
</head>
<body>
<%@ include file="topmenu.jsp" %>

<div class="title">수강신청</div>
	<div class="wrapper">
	<table id="joinTable" width="700" cellpadding="0" cellspacing="0" border="1">
      <form name="joinForm" action="class_join.do" method="post">
         <tr>
            <td> 수강월 </td>
            <td> <input class="float-input" type="text" name="regist_month" size = "50"> 2022년03월 예)202203 </td>
         </tr>
         <tr>
            <td> 회원명 </td>
            <td> <input class="float-input" type="text" name="c_name" size = "50"> </td>
         </tr>
         <tr>
            <td> 회원번호 </td>
            <td> <input class="float-input" type="text" name="c_no"> 예)10001</td>
         </tr>
         <tr>
            <td> 전화번호 </td>
            <td> <input class="float-input" type="text" name="phone"></td>
         </tr>
         <tr>
            <td> 주소 </td>
            <td> <input class="float-input" type="text" name="address"></td>
         </tr>
         <tr>
            <td> 강의장소 </td>
            <td> 
            <select name="class_area">
            	<option value="">
            	<option value="서울본원">서울본원</option>
            	<option value="성남분원">성남분원</option>
            	<option value="대전본원">대전본원</option>
            	<option value="부산본원">부산본원</option>
            	<option value="대구본원">대구본원</option>
            </select>
            </td>
         </tr>
          <tr>
            <td> 강의명 </td>
            <td> 
            <select name="teacher_code">
            	<option value="" />
            	<option value="100">초급반</option>
            	<option value="200">중급반</option>
            	<option value="300">고급반</option>
            	<option value="400">심화반</option>
            </select>
            </td>
         </tr>
         <tr>
         	<td> 등급 </td>
         	<td>
         	<select name="grade">
         		<option value="" />
         		<option value="일반">일반</option>
         		<option value="VIP">VIP</option>
         	</select>
         	</td>
         </tr>
         <tr>
            <td> 금액 </td>
            <td> <input class="float-input" type="text" name="tuition" size = "50"> </td>
         </tr>
         <tr >
         	<td style="text-align: center" colspan="2"> <input style="clear: both;" class="button" type="submit" value="수강신청" onclick="fn_submit(); return false;"><input class="button" type="reset" value="다시쓰기"></td>
         </tr>
      </form>
   </table>
   </div>
   <%@ include file="footer.jsp" %>
</body>
</html>