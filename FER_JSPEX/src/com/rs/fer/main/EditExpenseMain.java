package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class EditExpenseMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();
		Expense expense = new Expense();
		
		expense.setExpenseType("Grossaries");
		expense.setByWhom("padma");
		expense.setExpenseId(1);

		boolean editExpenseReportFlag = ferService.editExpense(expense);
		if (editExpenseReportFlag) {
			System.out.println("Edit successfully");
		} else {
			System.out.println("Edit failed");
		}

	}

}
