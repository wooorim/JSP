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
	
	/* Connection connection;
	Statement statement;
	ResultSet resultset; */
	
	String sql = "SELECT * FROM dept";
	
	Connection con = DriverManager.getConnection(url, "scott", "tiger");
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(sql);
	
	while(rs.next()){
		out.println("부서번호: " + rs.getString("deptno") + ("<br>"));
		out.println("부서이름: " + rs.getString("dname") + ("<br>"));
		out.println("부서위치: " + rs.getString("loc") + ("<br>"));
		out.println("<hr>");
	}
	
	//순서 지켜줘야된다. 끝(밑)에서부터 닫는다.
	rs.close(); 
	st.close();
	con.close();
	
	%>
</body>
</html>