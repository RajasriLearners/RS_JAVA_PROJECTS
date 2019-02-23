package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class ExpenseReportServlet extends HttpServlet{

	FERService ferService=null;
	@Override
	public void init() throws ServletException {
		ferService = new FERServiceImpl();
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out=response.getWriter();
		
		String expenseType=request.getParameter("expenseType");
		String fromDate=request.getParameter("fromDate");
		String toDate=request.getParameter("toDate");
		List<Expense> expenses=ferService.getExpenseReport(expenseType, fromDate, toDate, Integer.parseInt(session.getAttribute("userId").toString()));
		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("userName").toString());
		if(expenses!=null)
		{
		out.println("<table border='1' align='center'>");
		 	
		out.print("<tr>");
		out.print("<td>ExpenseType</td>");
		out.print("<td>Date</td>"); 
		out.print("<td>Price</td>");
		out.print("<td>No of items</td>");
		out.print("<td>Total</td>");
		out.print("<td>By whom</td>");
		out.print("<td>Action</td>");
		out.print("</tr>");	
		
		for(Expense expense:expenses) {
			out.print("<tr>");
			out.print("<td>"+expense.getExpenseType()+"</td>");
			out.print("<td>"+expense.getDate()+"</td>"); 
			out.print("<td>"+expense.getPrice()+"</td>");
			out.print("<td>"+expense.getNumberOfItems()+"</td>");
			out.print("<td>"+expense.getTotal()+"</td>");
			out.print("<td>"+expense.getByWhom()+"</td>");
			out.println("<td><input type='button' value='Edit' onclick=\"javascript: submitForm('displaydEditExpenseOption');\"</td>");
			out.println("<td><input type='button' value='Delete' onclick=\"javascript: submitForm('displayDeleteExpense');\"</td>");
			out.print("</tr>");
		}
		out.println("</table>");
		}else {
			out.println("No expense found");
		}
		
	 
		HTMLUtil.displayFooter(request, response);
		
		
	}
	@Override
	public void destroy() {
		ferService=null;
		}
}
