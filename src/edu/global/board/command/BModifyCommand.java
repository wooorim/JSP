package edu.global.board.command; //����� ��Ű�� ���� ���� ����

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
		
		BDao dao = new BDao(); //BDaoȣ��
		dao.modify(bid, bname, btitle, bcontent);
	}
}
