package edu.global.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.global.board.command.BCommand;
import edu.global.board.command.BContentCommand;
import edu.global.board.command.BDeleteCommand;
import edu.global.board.command.BListCommand;
import edu.global.board.command.BModifyCommand;
import edu.global.board.command.BReplyCommand;
import edu.global.board.command.BReplyViewCommand;
import edu.global.board.command.BWriteCommand;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.do") 
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
		
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //이 클래스안에서만 사용 가능
		System.out.println("actionDo() .."); //디버깅 코드. 이 함수를 타고 있는지 확인용.
		
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		BCommand command = null; //Model부분
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String com = uri.substring(contextPath.length());
		
		// /servlet_board/list.do
		// contextPath: /servlet_board 
		// com: /list.do
		
		System.out.println("uri" + uri);
		System.out.println("contextPath" + contextPath);
		System.out.println("com" + com);
		
		if(com.equals("/list.do")) {
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		}else if(com.equals("/content_view.do")) {
			command = new BContentCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";
		}else if(com.equals("/modify.do")) {
			command = new BModifyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}else if(com.equals("/delete.do")) {
			command = new BDeleteCommand();
			System.out.println("/delete.do..");
			command.execute(request, response);
			viewPage = "list.do";
		}else if(com.equals("/write_view.do")) { 
			System.out.println("/write_view.do..");
			viewPage = "write_view.jsp"; //입력화면을 뿌려주기만 하는 jsp(View)파일 
		}else if(com.equals("/write.do")) { //입력한 내용을 DB에 전송(저장)하는 파일
			System.out.println("/write.do..");
			command = new BWriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}else if(com.equals("/reply_view.do")) { //입력한 내용을 DB에 전송(저장)하는 파일
			System.out.println("/reply_view.do..");
			command = new BReplyViewCommand();
			command.execute(request, response);
			viewPage = "reply_view.jsp"; //해당 bid찾아가서 내용 가져와야된다.
		}else if(com.equals("/reply.do")) { //입력한 내용을 DB에 전송(저장)하는 파일
			System.out.println("/reply.do..");
			command = new BReplyCommand();
			command.execute(request, response);
			viewPage = "list.do"; //해당 bid찾아가서 내용 가져와야된다.
		}
		
		RequestDispatcher dispacher = request.getRequestDispatcher(viewPage);
		dispacher.forward(request, response);
		//request객체안에 넣은 게시글 정보의 유효범위가 forward가 끝날 때까지 살아있다.
		//파파라치는 데이터를 넘겨줄 떄 forwarding를 사용할 수 밖에 없다.
		//viewPage에 request객체를 fowarding시킨다 -> RequestDispatcher
	
		
		//클라이언트가 list.do로치고 들어오면 DAO를 통해서 request객체안에 게시판 글을 넣는다.
		
		
	}
}
