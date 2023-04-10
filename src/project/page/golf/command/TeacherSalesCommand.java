package project.page.golf.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.page.golf.dao.TeacherSalesDAO;
import project.page.golf.vo.TeacherSalesVO;

public class TeacherSalesCommand implements GolfCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		TeacherSalesDAO dao = new TeacherSalesDAO();
		
		List<TeacherSalesVO> vos = dao.SList();
		request.setAttribute("sales", vos);
	}
}
