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
		//request객체는 forwarding가 끝날 때까지 정보가 남아있고, request객체에는 DB정보가 담겨져있다.
		//DB정보를 jsp파일에 넘기기위해서는 .do로 전달할 수 밖에 없다.
	}
}
