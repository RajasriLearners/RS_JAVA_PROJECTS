package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class LoginServlet extends HttpServlet {
	FERService ferService = null;

	@Override
	public void init() throws ServletException {

		ferService = new FERServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int userId = ferService.login(request.getParameter("userName"), request.getParameter("password"));
		PrintWriter out = response.getWriter();
		String forwardpath = "";
		if (userId > 0) {
			
			HttpSession session = request.getSession();
			session.setAttribute("userName", request.getParameter("userName"));
			session.setAttribute("userId", userId);
			
			HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("userName").toString());
			out.println("Welcome to the user" + request.getParameter("userName"));
			HTMLUtil.displayFooter(request, response);
		} else {
			out.println("Login failed");
			forwardpath = "Login.html";
			request.getRequestDispatcher(forwardpath).include(request, response);
		}

	}

	@Override
	public void destroy() {
		ferService = null;
	}
}
