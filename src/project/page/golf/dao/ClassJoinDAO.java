package project.page.golf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ClassJoinDAO {
	private DataSource dataSource;
	
	public ClassJoinDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			System.out.println(dataSource);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int classJoin(String regist_month, String c_no, String class_area, int tuition, String teacher_code){
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		int rn = 0;
				
		try {
			con = dataSource.getConnection();
			
			String sql = "insert into tbl_class_202201 values (?, ?, ?, ?, ?)";
			preparedStatement = con.prepareStatement(sql);
			
			preparedStatement.setString(1, regist_month);
			preparedStatement.setString(2, c_no);
			preparedStatement.setString(3, class_area);
			preparedStatement.setInt(4, tuition);
			preparedStatement.setString(5, teacher_code);
			
			rn = preparedStatement.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
				if(con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return rn;
	}
	
	public int memberJoin(String c_no ,String c_name, String phone, String address, String grade) {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		int rn = 0;
	
		try {
			con = dataSource.getConnection();
			
			String sql = "insert into tbl_member_202201 values (?, ?, ?, ?, ?)";
			preparedStatement = con.prepareStatement(sql);
			
			preparedStatement.setString(1, c_no);
			preparedStatement.setString(2, c_name);
			preparedStatement.setString(3, phone);
			preparedStatement.setString(4, address);
			preparedStatement.setString(5, grade);
			
			rn = preparedStatement.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
				if(con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return rn;
	}
}
