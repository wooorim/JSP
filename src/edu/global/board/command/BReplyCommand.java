package edu.global.board.command; //기능은 패키지 별로 만들어서 저장

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.global.board.dao.BDao;
import edu.global.vo.BoardVO;

/**
 * Servlet implementation class BoardController
 */

public class BReplyCommand implements BCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bid = request.getParameter("bid");
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bgroup = request.getParameter("bgroup");
		String bstep = request.getParameter("bgroup");
		String bindent = request.getParameter("bindent");
		
		BDao dao = new BDao();
		
		dao.reply(bid, bname, btitle, bcontent, bgroup, bstep, bindent);
	}
}
