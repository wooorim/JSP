package edu.global.ex.vo;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.*;

public class DeptDAO { // DAO = Data Access Object
// 현업에서는 커넥션 풀 기법을 사용하기 때문에 밑의 선언은 거의 안함.
//	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
//	private String uid = "scott";
//	private String upw = "tiger";

	private DataSource dataSource; // DataSource(커넥션 풀 객체) = 모든connection pool에담겨있는 connection객체를 가져오는 자바 객체

	public DeptDAO() { // 객체 생성할 때 Driver불러오기
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver"); 
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		try {
			Context context = new InitialContext(); // Context = Context.xml의 세팅된 것 들을 가져오는 객체
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle"); // oracle부분은 context.xml의 name(이름)이랑
																					// 동일하게
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<DeptVO> deptSelect() {
		List<DeptVO> vos = new ArrayList<DeptVO>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM DEPT";

//			con = DriverManager.getConnection(url, uid, upw); //connection객체 요청 받을 때마다 매번 생성된다.(서버 부화 일어나버림)
			con = dataSource.getConnection(); // 커넥션 풀 객체 사용 시 선언(dataSource객체 사용)
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int deptno = rs.getInt("DEPTNO"); // getInt int형을 넘겨준다
				String loc = rs.getString("LOC"); // 컬럼명은 대문자로 별로 안쓴다.
				String dname = rs.getString("DNAME");

				DeptVO vo = new DeptVO(deptno, dname, loc);
				vos.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // try-catch안에 에러가 나든 안나든 finally는 실행된다.
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return vos;
	}

}
