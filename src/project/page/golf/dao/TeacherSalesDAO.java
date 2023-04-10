package project.page.golf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import project.page.golf.vo.TeacherSalesVO;

public class TeacherSalesDAO {
	private DataSource dataSource;
	
	public TeacherSalesDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			System.out.println(dataSource);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<TeacherSalesVO> SList(){
		List<TeacherSalesVO> vos = new ArrayList<TeacherSalesVO>();
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "select T.teacher_code as �����ڵ�, T.class_name as ���Ǹ�, T.teacher_name as �����, to_char(C.tuition, 'L999,999') as �Ѹ��� from tbl_teacher_202201 T, tbl_class_202201 C where T.teacher_code = C.teacher_code";
			preparedStatement = con.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String teacher_code = rs.getString("�����ڵ�");
				String class_name = rs.getString("���Ǹ�");
				String teacher_name = rs.getString("�����");
				String tuition = rs.getString("�Ѹ���");
				
				TeacherSalesVO vo = new TeacherSalesVO(teacher_code, class_name, teacher_name, tuition);
				vos.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(preparedStatement != null)
					preparedStatement.close();
				if(con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return vos;
	}
	
	
}
