package edu.global.board.command; //����� ��Ű�� ���� ���� ����

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
		//request��ü�� forwarding�� ���� ������ ������ �����ְ�, request��ü���� DB������ ������ִ�.
		//DB������ jsp���Ͽ� �ѱ�����ؼ��� .do�� ������ �� �ۿ� ����.
	}
}
