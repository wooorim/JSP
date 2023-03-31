package edu.global.ex.vo;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.*;

public class DeptDAO { // DAO = Data Access Object
// ���������� Ŀ�ؼ� Ǯ ����� ����ϱ� ������ ���� ������ ���� ����.
//	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
//	private String uid = "scott";
//	private String upw = "tiger";

	private DataSource dataSource; // DataSource(Ŀ�ؼ� Ǯ ��ü) = ���connection pool������ִ� connection��ü�� �������� �ڹ� ��ü

	public DeptDAO() { // ��ü ������ �� Driver�ҷ�����
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver"); 
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		try {
			Context context = new InitialContext(); // Context = Context.xml�� ���õ� �� ���� �������� ��ü
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle"); // oracle�κ��� context.xml�� name(�̸�)�̶�
																					// �����ϰ�
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

//			con = DriverManager.getConnection(url, uid, upw); //connection��ü ��û ���� ������ �Ź� �����ȴ�.(���� ��ȭ �Ͼ����)
			con = dataSource.getConnection(); // Ŀ�ؼ� Ǯ ��ü ��� �� ����(dataSource��ü ���)
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int deptno = rs.getInt("DEPTNO"); // getInt int���� �Ѱ��ش�
				String loc = rs.getString("LOC"); // �÷����� �빮�ڷ� ���� �Ⱦ���.
				String dname = rs.getString("DNAME");

				DeptVO vo = new DeptVO(deptno, dname, loc);
				vos.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // try-catch�ȿ� ������ ���� �ȳ��� finally�� ����ȴ�.
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
