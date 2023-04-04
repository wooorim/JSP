package edu.global.board.command; //����� ��Ű�� ���� ���� ����

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.global.board.dao.BDao;
import edu.global.vo.BoardVO;

/**
 * Servlet implementation class BoardController
 */

public class BReplyViewCommand implements BCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bid = request.getParameter("bid");
		
		
		BDao dao = new BDao(); //BDaoȣ��
		BoardVO vo = dao.reply_view(bid);
		dao.reply_view(bid);
		
		request.setAttribute("reply_view", vo);
	}
}
