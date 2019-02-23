package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class RegistrationServlet extends HttpServlet {
	FERService ferService=null;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ferService = new FERServiceImpl();
		
	}
	  @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		    User user = new User();
			user.setFirstName(request.getParameter("firstName"));
			user.setMiddleName(request.getParameter("middleName"));
			user.setLastName(request.getParameter("lastName"));
			user.setEmail(request.getParameter("e-Mail"));
			user.setUserName(request.getParameter("userName"));
			user.setPassword(request.getParameter("password"));
			user.setMobile(Integer.parseInt(request.getParameter("mobile")));

			boolean registrationFlag = ferService.registration(user);
			PrintWriter out=response.getWriter();
			
			String forwardpath="";
			
			if (registrationFlag) {
				out.println("Registration successfully done");
				forwardpath="Login.html";
			} else {
				out.println("unable to Register");
				forwardpath="Registration.html";
			}
			request.getRequestDispatcher(forwardpath).include(request, response);
	}
	  @Override
	public void destroy() {
		  ferService=null;
	}
}
