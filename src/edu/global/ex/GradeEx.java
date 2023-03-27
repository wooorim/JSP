package edu.global.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.global.ex.java.Grade;

/**
 * Servlet implementation class GradeEx
 */
@WebServlet("/grade")
public class GradeEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeEx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()"); 
		
		request.setCharacterEncoding("UTF-8"); //""내용을 찾아가서 가져올 때는 무조건 String형태(input 텍스트 박스는)
		
//		방법2
//		int kor = Integer.valueOf(request.getParameter("kor".trim()));
//		int eng = Integer.valueOf(request.getParameter("eng".trim()));
//		int math = Integer.valueOf(request.getParameter("math".trim()));
		
		String getKor = request.getParameter("kor".trim()); //trim은 불필요한 공백을 제거
		String getEng = request.getParameter("eng".trim());
		String getMath = request.getParameter("math".trim());
		
		double kor = Double.valueOf(getKor);
		double eng = Double.valueOf(getEng);
		double math = Double.valueOf(getMath);
		
		Grade grade = new Grade(kor, eng, math);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head></head><body>");
		out.println("총점 : " + grade.getSum());
		out.println("평균 : " + grade.getAvg());
		out.println("</body></html>");
		doGet(request, response);
	}

}
