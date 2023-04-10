package edu_mwr_ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Formet2
 */
@WebServlet("/FormEx2") //@(에너테이션)= 하나의 기능이 있는 함수와 비슷한 역할
public class FormEx2 extends HttpServlet { //HttpServlet(Http프로토콜을 캡슐화시킨 객체)을 상속받는 클래스를 서버 프로그래밍
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	public FormEx2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost..");

		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String id = request.getParameter("id");
		System.out.println(name);
		System.out.println(id);

//=================================================================================
		response.setContentType("text/html; charset=UTF-8"); //사용자 쪽에 html형태로 응답
		PrintWriter writer = response.getWriter(); //빨대 
		//위의 선언은밑의 println()내용을 그대로 뿌려주는 역햘
		writer.println("<html><head></head><body>");
		writer.println("<h1>" + "id : " + id + "</h1>" + "<br>");
		writer.println("<h1>" + "name : " + name + "</h1>" + "<br>");
		writer.println("</body></html>");

		doGet(request, response);
	}

}
