package project.page.golf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import project.page.golf.vo.MemberVO;

public class MemberDAO {
	private DataSource dataSource;
	
	public MemberDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			System.out.println(dataSource);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> MList(){
		List<MemberVO> vos = new ArrayList<MemberVO>();
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "select C.regist_month as ������, M.c_no as ȸ����ȣ, M.c_name ȸ���� , T.class_name ���Ǹ�, C.class_area as �������, to_char(C.tuition, 'L999,999') as ������, M.grade as ��� from tbl_teacher_202201 T, tbl_member_202201 M, tbl_class_202201 C where C.c_no = M.c_no and T.teacher_code = C.teacher_code";
			preparedStatement = con.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String regist_month = rs.getString("������");
				String c_no = rs.getString("ȸ����ȣ");
				String c_name = rs.getString("ȸ����");
				String class_name = rs.getString("���Ǹ�");
				String class_area = rs.getString("�������");
				String tuition = rs.getString("������");
				String grade = rs.getString("���");
				
				MemberVO vo = new MemberVO(regist_month, c_no, c_name, class_name, class_area, tuition, grade);
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
