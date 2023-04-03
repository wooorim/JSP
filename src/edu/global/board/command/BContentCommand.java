package edu.global.board.command; //기능은 패키지 별로 만들어서 저장

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.global.board.dao.BDao;
import edu.global.vo.BoardVO;

/**
 * Servlet implementation class BoardController
 */

public class BContentCommand implements BCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bid = request.getParameter("bid");
		BDao dao = new BDao();
		BoardVO vo = dao.contentView(bid);
		
		request.setAttribute("content_view", vo);
	}
}
