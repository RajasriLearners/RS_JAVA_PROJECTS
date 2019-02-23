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

public class DisplayPersonalReviewInfoServlet extends HttpServlet{
	FERService ferService = null;
	@Override
	public void init() throws ServletException {
		
		ferService = new FERServiceImpl();
			}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("userName").toString());
	
		//PersonalInfo personalInfo=ferService.getPersonalInfo(Integer.parseInt(session.getAttribute("userId").toString()));
		//session.setAttribute("personalInfo", personalInfo);
		
		PersonalInfo personalInfo=(PersonalInfo) session.getAttribute("personalInfo");
		
		personalInfo.getAddress().setAddressLine1(request.getParameter("addressLine1"));
		personalInfo.getAddress().setAddressLine2(request.getParameter("addressLine2"));
		personalInfo.getAddress().setStreet(request.getParameter("street"));
		personalInfo.getAddress().setCity(request.getParameter("city"));
		personalInfo.getAddress().setState(request.getParameter("state"));
		personalInfo.getAddress().setZip(Integer.parseInt(request.getParameter("zip")));
		
	
		out.println("<table border='1' align='center'>");
		out.print("<tr>");
		out.print("<td colspan='2' align='center'>Review</td>");
		out.print("</tr>");
		
		
		out.print("<tr>");
		out.print("<td>FirstName</td>");
		out.print("<td><input type='text' name='firstName' value='"+personalInfo.getUser().getFirstName()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>LastName</td>");
		out.println("<td><input type='text' name='lastName' value='"+personalInfo.getUser().getLastName()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>MiddleName</td>");
		out.println("<td><input type='text' name='middleName' value='"+personalInfo.getUser().getMiddleName()+"'></td>");
		out.println("</tr>");
		
		out.print("<tr>");
		out.print("<td>Mobile Number</td>");
		out.print("<td><input type='text' name='mobile' value='"+personalInfo.getUser().getMobile()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Email</td>");
		out.println("<td><input type='text' name='email' value='"+personalInfo.getUser().getEmail()+"'></td>");
		out.println("</tr>");

		
		out.print("<tr>");
		out.print("<td>AddressLine1</td>");
		out.print("<td><input type='text' name='addressLine1' value='"+personalInfo.getAddress().getAddressLine1()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>AddressLine2</td>");
		out.println("<td><input type='text' name='addressLine2' value='"+personalInfo.getAddress().getAddressLine2()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Street</td>");
		out.println("<td><input type='text' name='street' value='"+personalInfo.getAddress().getStreet()+"'></td>");
		out.println("</tr>");
		
			
		out.println("<tr>");
		out.println("<td>City</td>");
		out.println("<td><input type='text' name='city' value='"+personalInfo.getAddress().getCity()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>State</td>");
		out.println("<td><input type='text' name='state' value='"+personalInfo.getAddress().getState()+"'></td>");
		out.println("</tr>");
	
		
		out.println("<tr>");
		out.println("<td>Zip</td>");
		out.println("<td><input type='text' name='zip' value='"+personalInfo.getAddress().getZip()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td colspan='2' align='center'><input type='button' value='Next' onclick=\"submitForm('updatePersonalInfoServlet')\"></td>");
		out.println("</tr>");
		out.println("</table>");

		HTMLUtil.displayFooter(request, response);

	}
	@Override
	public void destroy() {
		ferService = null;
		
	}
}
