package edu.global.ex.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.*;

public class EmpDAO { 
//	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	private String uid = "scott";
//	private String upw = "tiger";
	private DataSource dataSource;
	public EmpDAO() {
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle"); //정해진 경로
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<EmpVO> empSelect(){
		List<EmpVO> vos = new ArrayList<EmpVO>();
		
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from emp";
			
//			con = DriverManager.getConnection(url, uid, upw);
			con = dataSource.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				
				EmpVO vo = new EmpVO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				//원하는 정보만 가져오고 싶을 때
				//EmpVO vo = new EmpVO();
				//vo.setHeiredate(hiredate); setter함수로 접근한다.
				vos.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(stmt != null)
					stmt.close();
				if(con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vos;
	}
} 
