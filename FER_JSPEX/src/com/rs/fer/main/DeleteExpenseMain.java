package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class DeleteExpenseMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();

		boolean deleteExpenseFlag = ferService.deleteExpense(7);

		if (deleteExpenseFlag) {
			System.out.println("Delete successfully");
		} else {
			System.out.println("Delete failed -- please check the db record is existing or not");
		}

	}

}
