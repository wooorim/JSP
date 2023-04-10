package project.page.golf.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.page.golf.command.ClassJoinCommand;
import project.page.golf.command.GolfCommand;
import project.page.golf.command.MemberCommand;
import project.page.golf.command.TeacherCommand;
import project.page.golf.command.TeacherSalesCommand;

/**
 * Servlet implementation class GolfCotroller
 */
@WebServlet("*.do")
public class GolfCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GolfCotroller() {
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

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo()..");
		
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		GolfCommand command = null; //Model부분
		
		String uri = request.getRequestURI(); //현재 요청의 URI(Uniform Resource Identifier)를 문자열로 반환
		String contextPath = request.getContextPath(); //substring() 메소드는 문자열에서 특정 범위의 문자열을 추출하는 메소드,
		String com = uri.substring(contextPath.length());
		
		// /servlet_board/list.do
		// contextPath: /servlet_board 
		// com: /list.do
		
		System.out.println("uri" + uri);
		System.out.println("contextPath" + contextPath);
		System.out.println("com" + com);
		
		if(com.equals("/teacher.do")) {
			System.out.println("/teacher.do..");
			command = new TeacherCommand();
			command.execute(request, response);
			viewPage = "teacher.jsp";
		}else if(com.equals("/member.do")) {
			System.out.println("/memeber.do..");
			command = new MemberCommand();
			command.execute(request, response);
			viewPage = "member.jsp";
		}else if(com.equals("/teacher_sales.do")) {
			System.out.println("/teacher_sales.do..");
			command = new TeacherSalesCommand();
			command.execute(request, response);
			viewPage = "teacher_sales.jsp";
		}else if(com.equals("/class_join_view.do")) {
			System.out.println("/class_join_view.do..");
			viewPage = "class_join_view.jsp"; 
	    }else if(com.equals("/class_join.do")) {
	    	System.out.println("/class_join.do..");
	    	command = new ClassJoinCommand();
	    	command.execute(request, response);
	    	viewPage = "/member.do";
	    }
		
			  
		RequestDispatcher dispacher = request.getRequestDispatcher(viewPage);
		dispacher.forward(request, response);
	}
}
