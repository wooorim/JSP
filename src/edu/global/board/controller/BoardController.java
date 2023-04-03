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
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //�� Ŭ�����ȿ����� ��� ����
		System.out.println("actionDo() .."); //����� �ڵ�. �� �Լ��� Ÿ�� �ִ��� Ȯ�ο�.
		
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		BCommand command = null; //Model�κ�
		
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
		}
		
		RequestDispatcher dispacher = request.getRequestDispatcher(viewPage);
		dispacher.forward(request, response);
		//request��ü�ȿ� ���� �Խñ� ������ ��ȿ������ forward�� ���� ������ ����ִ�.
		//viewPage�� request��ü�� fowarding��Ų�� -> RequestDispatcher
	
		
//		Ŭ���̾�Ʈ�� list.do��ġ�� ������ DAO�� ���ؼ� request��ü�ȿ� �Խ��� ���� �ִ´�.
		
		
	}
}
