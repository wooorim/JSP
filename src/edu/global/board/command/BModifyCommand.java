package edu.global.board.command; //기능은 패키지 별로 만들어서 저장

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.global.board.dao.BDao;
import edu.global.vo.BoardVO;

/**
 * Servlet implementation class BoardController
 */

public class BModifyCommand implements BCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bid = request.getParameter("bid");
		String bname = request.getParameter("bname");
		String bcontent = request.getParameter("bcontent");
		String btitle = request.getParameter("btitle");
		
		System.out.println(bid);
		System.out.println(bname);
		System.out.println(bcontent);
		System.out.println(btitle);
		
		BDao dao = new BDao(); //BDao호출
		dao.modify(bid, bname, btitle, bcontent);
	}
}
