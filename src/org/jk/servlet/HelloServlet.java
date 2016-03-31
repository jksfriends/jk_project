package org.jk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2387546268596254341L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.print(" doGet <br> ");
		out.print(request.getParameter("hello")+" <br> ");
		out.print(" Hello Servlet World! ");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.print(" doPost <br> ");
		out.print(request.getParameter("hello")+" <br> ");
		out.print(" Hello Servlet World! ");
	}
}
