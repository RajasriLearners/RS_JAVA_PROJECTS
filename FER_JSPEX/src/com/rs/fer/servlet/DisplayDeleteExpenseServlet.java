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

public class DisplayDeleteExpenseServlet extends HttpServlet {
	FERService ferService = null;
	@Override
	public void init() throws ServletException {
		ferService = new FERServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		

		HttpSession session = request.getSession();
		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("userName").toString());
		List<Expense> expenses = new FERServiceImpl()
				.getExpenses(Integer.parseInt(session.getAttribute("userId").toString()));

		

		if (expenses != null && !expenses.isEmpty()) {
			out.println("Expense Id: ");
			out.println("<select name='expenseId'>");

			for (Expense expense : expenses) {
				String option = " " + expense.getExpenseId();
	 			out.println("<option value=" + expense.getExpenseId() + "> ");
				//out.println("<option value='" + expense.getExpenseId() + "'>");
				out.println(expense.getExpenseType() + "-" + expense.getDate() + "-" + expense.getTotal() + "-"
						+ expense.getByWhom());
				out.println("</option>");
			}
			

			out.println("</select>");
			
			//session.setAttribute("expenseId", request.getParameter("expenseId"));
			
			
			out.println("<input type='button' value='Delete' onclick=\"javascript: submitForm('deleteExpense');\"");
		} else {
			out.println("No expenses were found...");
		}

		HTMLUtil.displayFooter(request, response);

	}
	@Override
	public void destroy() {
		ferService = null;	}

}
