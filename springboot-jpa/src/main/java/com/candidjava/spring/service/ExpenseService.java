package com.candidjava.spring.service;

import java.util.List;

import com.candidjava.spring.bean.Expense;

public interface ExpenseService {

	public void createExpense(Expense expense);
	public List<Expense> getExpense();
	public Expense findById(int expenseId);
	public Expense update(Expense expense, int expenseId);
	public void deleteUserById(int expenseId);
	public Expense updatePartially(Expense expense, int expenseId);
	
}
