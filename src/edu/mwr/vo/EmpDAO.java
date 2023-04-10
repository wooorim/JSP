package edu.mwr.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;

public class EmpDAO {
	private DataSource dataSource;

	public EmpDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<EmpVO> empSelect() {
		List<EmpVO> vos = new ArrayList<EmpVO>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from emp";

			con = dataSource.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hireDate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");

				EmpVO vo = new EmpVO(empno, ename, job, mgr, hireDate, sal, comm, deptno);
				vos.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
