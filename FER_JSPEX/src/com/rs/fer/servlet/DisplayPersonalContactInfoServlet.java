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

public class DisplayPersonalContactInfoServlet extends HttpServlet{
	FERService ferService = null;
@Override
public void init() throws ServletException {
	
	ferService = new FERServiceImpl();
	}
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession();	
	PrintWriter out = response.getWriter();
	
	//PersonalInfo personalInfo=ferService.getPersonalInfo(Integer.parseInt(session.getAttribute("userId").toString()));
	//session.setAttribute("personalInfo", personalInfo);
	PersonalInfo personalInfo=(PersonalInfo) session.getAttribute("personalInfo");
	
	personalInfo.getUser().setFirstName(request.getParameter("firstName"));
	personalInfo.getUser().setFirstName(request.getParameter("lastName"));
	personalInfo.getUser().setFirstName(request.getParameter("middleName"));
	
	HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("userName").toString());
	out.println("<table border='1' align='center'>");
	out.print("<tr>");
	out.print("<td colspan='2' align='center'>ContactInfo</td>");
	out.print("</tr>");
	
	
	out.print("<tr>");
	out.print("<td>Mobile Number</td>");
	out.print("<td><input type='text' name='mobile' value='"+personalInfo.getUser().getMobile()+"'></td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>Email</td>");
	out.println("<td><input type='text' name='email' value='"+personalInfo.getUser().getEmail()+"'></td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td colspan='2' align='center'><input type='button' value='Next' onclick=\"submitForm('displayPersonalAddressInfoServlet')\"></td>");
	out.println("</tr>");
	out.println("</table>");

	
	HTMLUtil.displayFooter(request, response);
	

}
@Override
	public void destroy() {
	ferService = null;
	}
}
