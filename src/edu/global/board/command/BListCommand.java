package edu.global.board.command; //기능은 패키지 별로 만들어서 저장

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
		BDao dao = new BDao(); //BDao를 호출
		
		List<BoardVO> vos = dao.list();
		
		request.setAttribute("boards", vos);
//		BoardVO에 들어가있는 게시물 정보들을 request객체에 저장
	}
}
