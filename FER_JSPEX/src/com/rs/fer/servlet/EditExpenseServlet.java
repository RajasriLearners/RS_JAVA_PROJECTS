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

public class EditExpenseServlet extends HttpServlet{
	FERService ferService = null;
	@Override
	public void init() throws ServletException {
		ferService = new FERServiceImpl();
	}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	HttpSession session=request.getSession();
	
	PrintWriter out=response.getWriter();
	
	HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("userName").toString());
	Expense expense=(Expense)session.getAttribute("expense");
	
	expense.setExpenseType(request.getParameter("expenseType"));
	expense.setDate(request.getParameter("date"));
	expense.setPrice(Integer.parseInt(request.getParameter("price")));
	expense.setNumberOfItems(Integer.parseInt(request.getParameter("numberOfItems")));
	expense.setTotal(Integer.parseInt(request.getParameter("total")));
	expense.setByWhom(request.getParameter("byWhom"));
	
	boolean editExpense=ferService.editExpense(expense);
	out.println(editExpense?"Expense edited successfully":"Failed to edit expense");

	HTMLUtil.displayFooter(request, response);
	
}
@Override
public void destroy() {
	ferService = null;
}
	
}
