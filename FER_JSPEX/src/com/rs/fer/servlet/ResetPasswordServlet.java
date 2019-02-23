package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class ResetPasswordServlet extends HttpServlet {
	FERService ferService = null;

	@Override
	public void init() throws ServletException {
		ferService = new FERServiceImpl();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user=new User();

		PrintWriter out = response.getWriter();

		String currentPassword = request.getParameter("currentPassword");
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmNewPassword");
		HttpSession session = request.getSession();
		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("userName").toString());

		if (confirmPassword.equals(newPassword)) {
			boolean resetPasswordFlag = ferService.resetPassword(Integer.parseInt(session.getAttribute("userId").toString()), currentPassword, newPassword);
			out.println(resetPasswordFlag ? "Password Reset done successfully" : "Reset password failure");
			HTMLUtil.displayFooter(request, response);
		}

	}

	@Override
	public void destroy() {
		ferService = null;
	}

}
