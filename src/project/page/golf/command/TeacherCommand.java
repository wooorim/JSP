package project.page.golf.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.page.golf.dao.TeacherDAO;
import project.page.golf.vo.TeacherVO;

public class TeacherCommand implements GolfCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		TeacherDAO dao = new TeacherDAO();
		
		List<TeacherVO> vos = dao.TList();
		request.setAttribute("teachers", vos);
	}
}
