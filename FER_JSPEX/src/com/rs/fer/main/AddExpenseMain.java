package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class AddExpenseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FERService ferService = new FERServiceImpl();
		Expense expense = new Expense();
		
		expense.setExpenseType("Electronics");
		expense.setDate("30jan2018");
		expense.setPrice(30);
		expense.setNumberOfItems(4);
		expense.setTotal(120);
		expense.setByWhom("Siri");
		expense.setUserId(3);
		
		boolean expenseFlag = ferService.addExpense(expense);
		if (expenseFlag) {
			System.out.println("Expense added successfully");
		} else {
			System.out.println("Add Expense failed");
		}

	}

}
