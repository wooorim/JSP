<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="grade_result" method="post">
		국어: <input type="number" name="kor" size="10"><br>
		영어: <input type="number" name="eng" size="10"><br>
		수학: <input type="number" name="math" size="10"><br>
		<input type="submit" value="전송">
		<input type="reset" value="리셋">
	</form>
</body>
</html>