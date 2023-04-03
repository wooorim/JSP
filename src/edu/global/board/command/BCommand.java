package edu.global.board.command; //기능은 패키지 별로 만들어서 저장

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardController
 */

public interface BCommand {
	void execute(HttpServletRequest request, HttpServletResponse response); //void앞에 public abstract생략
}
//폴리모피즘 적용시키기 위해서 인터페이스 생성
//통일된 코드를 작성하기 위해서
