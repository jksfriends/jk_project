package org.jk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/helloNewServlet.do")
public class NewHelloServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2387546268596254341L;

	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.print(" service <br> ");
		out.print(" Hello New Servlet World! ");
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.print(" doGet <br> ");
		out.print(" Hello New Servlet World! ");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.print(" doPost <br> ");
		out.print(" Hello New Servlet World! ");
	}
}
