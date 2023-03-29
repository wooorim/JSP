<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<!-- sql로 import해준다 -->
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
	String url = "jdbc:oracle:thin:@localhost:1521/xe"; /* 1521:오라클 포트 번호, url은 반드시 복사해서 입력 */
	Class.forName("oracle.jdbc.driver.OracleDriver"); /* 복붙하기 */
	
	String sql = "SELECT * FROM EMP";
	
	Connection con = DriverManager.getConnection(url, "scott", "tiger");
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(sql);
	
	while(rs.next()){
		out.println("사원번호: " + rs.getString("EMPNO") + ("<br>"));
		out.println("사원이름: " + rs.getString("ENAME") + ("<br>"));
		out.println("직업: " + rs.getString("JOB") + ("<br>"));
		out.println("매니져: " + rs.getString("MGR") + ("<br>"));
		out.println("취업날짜: " + rs.getString("HIREDATE") + ("<br>"));
		out.println("월급: " + rs.getString("SAL") + ("<br>"));
		out.println("보너스: " + rs.getString("COMM") + ("<br>"));
		out.println("부서번호: " + rs.getString("DEPTNO") + ("<br>"));
		
		out.println("<hr>");
	}
	
	//순서 지켜줘야된다. 끝(밑)에서부터 닫는다.
	rs.close(); 
	st.close();
	con.close();
	
	%>
</body>
</html>