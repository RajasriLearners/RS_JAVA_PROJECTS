package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class DeleteExpenseServlet extends HttpServlet {
	FERService ferService=null;
	@Override
	public void init() throws ServletException {
		ferService = new FERServiceImpl();
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	HttpSession session = request.getSession();
	Expense expense = new Expense();
	
	PrintWriter out=response.getWriter();
	
	HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("userName").toString());
	
	int expenseId=Integer.parseInt(request.getParameter("expenseId"));
	

	boolean deleteExpenseFlag=ferService.deleteExpense(expenseId);
	out.println(deleteExpenseFlag ? "Expense deleted successfully" : "Failure expense deletion");
	
	HTMLUtil.displayFooter(request,response);
	
	}
	@Override
	public void destroy() {
		ferService=null;
			}
	

}
