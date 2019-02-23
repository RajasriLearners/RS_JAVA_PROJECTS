package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class UpdatePersonalInfoServlet extends HttpServlet{
	FERService ferService = null;
	@Override
	public void init() throws ServletException {
		
		ferService = new FERServiceImpl();
			}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		PersonalInfo personalInfo=(PersonalInfo) session.getAttribute("personalInfo");
		boolean isUpdated=ferService.updatePersonalInfo(personalInfo.getUser(),personalInfo.getAddress());
		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("userName").toString());
		out.println(isUpdated ? "Updated successfully" :"Updated failed");
		HTMLUtil.displayFooter(request, response);
	}
	@Override
	public void destroy() {
		ferService = null;
			}

}
