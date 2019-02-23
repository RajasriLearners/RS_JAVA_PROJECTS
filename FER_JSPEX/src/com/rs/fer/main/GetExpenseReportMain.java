package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetExpenseReportMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FERService ferService = new FERServiceImpl();
		List<Expense> expenses = ferService.getExpenseReport("Grossaries", "11-01-2019", "13-01-2019", 1);
		if (expenses != null) {
			for (Expense expense : expenses) {
				System.out.println("expenseType-" + expense.getExpenseType() + "  date-" + expense.getDate()
						+ "  price-" + expense.getPrice() + "  numberOfItems-" + expense.getNumberOfItems() + "  total-"
						+ expense.getTotal() + "  byWhom-" + expense.getByWhom());
			}
		} else {
			System.out.println("No expenses found for the given input");
		}

	}

}
