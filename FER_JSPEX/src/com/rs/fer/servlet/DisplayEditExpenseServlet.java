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

public class DisplayEditExpenseServlet extends HttpServlet {
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
		
		Expense expense=ferService.getExpense(Integer.parseInt(request.getParameter("expenseId")));
		session.setAttribute("expense", expense);
		
	
		out.println("<table border='1' align='center'>");
		out.print("<tr>");
		out.print("<td colspan='2' align='center'>EditExpense</td>");
		out.print("</tr>");
		
		out.print("<tr>");
		out.print("<td>ExpenseType</td>");
		out.print("<td><input type='text' name='expenseType' value='"+expense.getExpenseType()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Date</td>");
		out.println("<td><input type='text' name='date' value='"+expense.getDate()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>price</td>");
		out.println("<td><input type='text' name='price' value='"+expense.getPrice()+"'></td>");
		out.println("</tr>");
		
		
		
		out.println("<tr>");
		out.println("<td>numberOfItems</td>");
		out.println("<td><input type='text' name='numberOfItems' value='"+expense.getNumberOfItems()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>total</td>");
		out.println("<td><input type='text' name='total' value='"+expense.getTotal()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>ByWhom</td>");
		out.println("<td><input type='text' name='byWhom' value='"+expense.getByWhom()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td colspan='2' align='center'><input type='button' value='Edit Expense' onclick=\"submitForm('editExpenseStatus')\"></td>");
		out.println("</tr>");
		out.println("</table>");

		
		HTMLUtil.displayFooter(request, response);
	}

	@Override
	public void destroy() {
		ferService = null;
	}
}
