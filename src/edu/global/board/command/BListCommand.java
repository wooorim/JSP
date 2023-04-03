package edu.global.board.command; //����� ��Ű�� ���� ���� ����

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.global.board.dao.BDao;
import edu.global.vo.BoardVO;

/**
 * Servlet implementation class BoardController
 */

public class BListCommand implements BCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BDao dao = new BDao(); //BDao�� ȣ��
		
		List<BoardVO> vos = dao.list();
		
		request.setAttribute("boards", vos);
//		BoardVO�� ���ִ� �Խù� �������� request��ü�� ����
	}
}
