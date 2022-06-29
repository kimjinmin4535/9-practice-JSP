package kr.co.ezenac.session02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/show")
public class ShowMember extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id="",pwd="";
		Boolean isLogon = false;
		
		request.getSession();
		
		HttpSession session = request.getSession();
		if(session != null) {
			isLogon = (Boolean)session.getAttribute("isLogon");
			if(isLogon ==true) {
				id = (String)session.getAttribute("login.id");
				pwd = (String)session.getAttribute("login.pwd");
				out.print("<html><body>");
				out.print("아디"+id+"<br>");
				out.print("비번"+pwd+"<br>");
				out.print("<html><body>");
			}
			else {
				response.sendRedirect("login.html");
			}
		}
		else {
			response.sendRedirect("login.html");

			}
		}
	
}