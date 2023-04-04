package edu.global.board.command; //기능은 패키지 별로 만들어서 저장

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
		
		
		BDao dao = new BDao(); //BDao호출
		BoardVO vo = dao.reply_view(bid);
		dao.reply_view(bid);
		
		request.setAttribute("reply_view", vo);
	}
}
