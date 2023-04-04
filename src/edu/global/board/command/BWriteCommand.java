package edu.global.board.command; //기능은 패키지 별로 만들어서 저장

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.global.board.dao.BDao;
import edu.global.vo.BoardVO;

/**
 * Servlet implementation class BoardController
 */

public class BWriteCommand implements BCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BDao dao = new BDao();
		
		dao.write(bname, btitle, bcontent);
	}
}
