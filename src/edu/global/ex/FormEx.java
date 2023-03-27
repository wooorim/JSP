package edu.global.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/FormEx") //@WebServlet 페이지 주소
public class FormEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormEx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //method="get"일 떄
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		System.out.println("doGet() ..");
//		System.out.println(request.getRemoteAddr());
//		System.out.println(request.getRemoteHost());
//		
//		request.setCharacterEncoding("EUC-KR");
//		
//		//request 요청
//		String name = request.getParameter("name");
//		System.out.println(name);
//		
//		String id = request.getParameter("id");
//		System.out.println(id);
//		
//		//response 응답
//		response.setContentType("text/html;, charset=EUC_KR");
//		PrintWriter writer = response.getWriter();
//		writer.println("<html><head></head><body>");
//		writer.println("아이디: " + id + "<br>");
//		writer.println("이름: " + name + "<br>");
//		writer.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//method="post"일 때
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() ..");
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getRemoteHost());
		
		request.setCharacterEncoding("UTF-8");
		
		//request 요청
		String name = request.getParameter("name");
		System.out.println(name);
		
		String id = request.getParameter("id");
		System.out.println(id);
		
		String[] hobbys = request.getParameterValues("hobby");
		String major = request.getParameter("major");
		
		//response 응답
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html><head></head><body>");
		writer.println("아이디: " + id + "<br>");
		writer.println("취미: " + Arrays.toString(hobbys) + "<br>");
		writer.println("이름: " + name + "<br>");
		writer.println("전공: " + major + "<br>");
		writer.println("</body></html>");
		
		doGet(request, response);
		
		
	}

}
