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
@WebServlet("/FormEx2") //@(�������̼�)= �ϳ��� ����� �ִ� �Լ��� ����� ����
public class FormEx2 extends HttpServlet { //HttpServlet(Http���������� ĸ��ȭ��Ų ��ü)�� ��ӹ޴� Ŭ������ ���� ���α׷���
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
		response.setContentType("text/html; charset=UTF-8"); //����� �ʿ� html���·� ����
		PrintWriter writer = response.getWriter(); //���� 
		//���� ���������� println()������ �״�� �ѷ��ִ� ���l
		writer.println("<html><head></head><body>");
		writer.println("<h1>" + "id : " + id + "</h1>" + "<br>");
		writer.println("<h1>" + "name : " + name + "</h1>" + "<br>");
		writer.println("</body></html>");

		doGet(request, response);
	}

}
