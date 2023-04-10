package project.page.golf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import project.page.golf.vo.TeacherVO;

public class TeacherDAO {
	private DataSource dataSource;
	
	public TeacherDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			System.out.println(dataSource);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<TeacherVO> TList(){
		List<TeacherVO> vos = new ArrayList<TeacherVO>();
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "SELECT TEACHER_CODE, TEACHER_NAME, CLASS_NAME,  TO_CHAR(CLASS_PRICE, 'L999,999') as 수강료, TO_CHAR(TEACHER_REGIST_DATE,  'YYYY\"년\"MM\"월\"DD\"일\"') as 강사자격취득일 FROM TBL_TEACHER_202201";
			
			preparedStatement = con.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String teacher_code = rs.getString("teacher_code");
				String teacher_name = rs.getString("teacher_name");
				String class_name = rs.getString("class_name");
				String class_price = rs.getString("수강료");
				String teacher_regist_date = rs.getString("강사자격취득일");
				
				TeacherVO vo = new TeacherVO(teacher_code, teacher_name, class_name, class_price, teacher_regist_date);
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
