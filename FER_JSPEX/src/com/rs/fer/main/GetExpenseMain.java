
package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetExpenseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FERService ferService = new FERServiceImpl();
		Expense expense = ferService.getExpense(4);
		if (expense != null) {
			System.out.println("Expense byWhom: " + expense.getByWhom() +" Date " + expense.getDate()+ " Price" + expense.getPrice()+" Number of items" +expense.getNumberOfItems()+" Total" + expense.getTotal());
		} else {
			System.out.println("Get expense failed");
		}

	}

}
