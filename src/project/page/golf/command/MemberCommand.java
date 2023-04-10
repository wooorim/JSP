package project.page.golf.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.page.golf.dao.MemberDAO;
import project.page.golf.vo.MemberVO;

public class MemberCommand implements GolfCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO dao = new MemberDAO();
		
		List<MemberVO> vos = dao.MList();
		request.setAttribute("members", vos);
	}
}
