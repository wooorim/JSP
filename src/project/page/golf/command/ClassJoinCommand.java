package project.page.golf.command; //기능은 패키지 별로 만들어서 저장

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.page.golf.dao.ClassJoinDAO;

/**
 * Servlet implementation class BoardController
 */
//C_NO	CHAR(5 BYTE)	No		1	
//C_NAME	VARCHAR2(15 BYTE)	Yes		2	
//PHONE	VARCHAR2(11 BYTE)	Yes		3	
//ADDRESS	VARCHAR2(50 BYTE)	Yes		4	
//GRADE	VARCHAR2(6 BYTE)	Yes		5	

public class ClassJoinCommand implements GolfCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String regist_month = request.getParameter("regist_month");
		String c_no = request.getParameter("c_no");
		String c_name = request.getParameter("c_name");
		String class_area = request.getParameter("class_area");
		int tuition = Integer.valueOf(request.getParameter("tuition"));
		String teacher_code = request.getParameter("teacher_code");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String grade = request.getParameter("grade");
		
		ClassJoinDAO dao = new ClassJoinDAO();
		dao.memberJoin(c_no, c_name, phone, address, grade);
		dao.classJoin(regist_month, c_no, class_area, tuition, teacher_code);
		
		
	}
}
