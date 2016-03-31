package org.jk.user.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jk.user.dao.UserDTO;
import org.jk.user.service.UserService;
import org.jk.user.service.UserServiceImpl;

@WebServlet("/user/userlist.do")
public class UserController extends HttpServlet {
	
	private UserService service = new UserServiceImpl();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2387546268596254341L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List<UserDTO> list = service.getUserList();
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.print(" DB CONNECTING TEST <br> ");
		for(UserDTO dto : list) {
			out.print(dto+" <br> ");
		}
	}
	
}
