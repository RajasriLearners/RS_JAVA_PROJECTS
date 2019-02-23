package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetExpensesMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FERService ferService = new FERServiceImpl();
		List<Expense> expenses = ferService.getExpenses(3);
		if (expenses != null) {
			for (Expense expense : expenses) {
				System.out.println("expenseType-" + expense.getExpenseType()+" byWhom: " + expense.getByWhom() +" Date" + expense.getDate()+ " Price" + expense.getPrice()+" Number of items" +expense.getNumberOfItems()+" Total" + expense.getTotal());
			}
		} else {
			System.out.println("expense not found");
		}

	}

}
