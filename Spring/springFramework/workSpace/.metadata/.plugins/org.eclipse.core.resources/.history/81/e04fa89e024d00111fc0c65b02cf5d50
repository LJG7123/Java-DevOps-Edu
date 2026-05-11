package kosta.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 이 클래스가 웹브라우저에서 동작(실행)할 수 있게 하고 싶다
 * 	=> 자바 중심의 코드에서 마크업을 섞어서 사용할 수 있다
 * 
 * 조건: 
 * 	1) 반드시 public 클래스로 선언
 * 	2) HttpServlet을 상속받음
 * 	3) 필요한 메소드(Servlet의 lifecycle에 관련된 메소드)를 재정의해서 기능을 작성
 * 	4) 브라우저에서 어떻게 요청하면 현재 Servlet이 실행될지에 해당하는 설정(web.xml or @annotation)이 필요하다
 */
public class Test03Servlet extends HttpServlet {
	
	public Test03Servlet() {
		System.out.println("Test03Servlet 생성자 호출됨");
	}
	
	/**
	 * 사용자 요청이 들어올 때 마다 호출되는 메소드
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=EUC-KR");
		
		System.out.println("요청이 들어왔어요");
		
		// 요청이 들어온 param 정보를 받기
		String id = request.getParameter("id");
		System.out.println("전달된 id = " + id);
		
		/*
		 * was쪽에서 이동하는 방식
		 * 1) redirect 방식 - 새로운 request와 response 생성해서 이동하는 방식
		 * response.sendRedirect(url주소);
		 * 
		 * 2) forward 방식 - 기존 request, response 유지하면서 이동하는 방식
		 * request.getRequestDispatcher(url주소).forward(request, response);
		 */
		if (id == null || !id.equals("ljg")) {
			// 실패 페이지로 이동
			// 이동 전에 뷰 쪽으로 전달될 데이터를 설정
			request.setAttribute("message", "id가 없거나 잘못된 정보입니다."); // 뷰에서 ${requestScope.message}
			
			// 1) redirect방식
//			response.sendRedirect("fail.jsp");
			
			// 2) forward방식
			request.getRequestDispatcher("fail.jsp").forward(request, response);
		} else {
			// 성공 페이지로 이동
			// 이동 전에 뷰 쪽으로 전달될 데이터를 설정
			request.setAttribute("hobbies", Arrays.asList("등산", "수영", "낚시")); // 뷰에서 ${requestScope.hobbies}
			
			// 1) redirect방식
//			response.sendRedirect("ok.jsp");
			
			// 2) forward방식
			request.getRequestDispatcher("ok.jsp").forward(request, response);
		}
		
		/*String name = "lllll";
		
		PrintWriter out = response.getWriter();
		out.println("<h1>Servlet 잘 되나?</h1>");
		out.println("<h2 style='color:red'>배고프다</h2>");
		out.println("이름은 " + name);*/
	}

}
