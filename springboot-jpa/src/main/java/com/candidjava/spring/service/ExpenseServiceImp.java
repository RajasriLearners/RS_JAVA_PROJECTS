package com.candidjava.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.candidjava.spring.bean.Expense;
import com.candidjava.spring.bean.User;
import com.candidjava.spring.bean.UserFER;
import com.candidjava.spring.repository.ExpenseRepository;

@Service
@Transactional
public class ExpenseServiceImp implements ExpenseService{

	@Autowired
	ExpenseRepository expenseRepository;
		
	@Override
	public void createExpense(Expense expense) {
		expenseRepository.save(expense);
	}

	@Override
	public List<Expense> getExpense() {
		return (List<Expense>) expenseRepository.findAll();
	}

	@Override
	public Expense findById(int expenseId) {
		return expenseRepository.findOne(expenseId);
	}

	@Override
	public Expense update(Expense expense, int expenseId) {
		return expenseRepository.save(expense);
	}

	@Override
	public void deleteUserById(int expenseId) {
		expenseRepository.delete(expenseId);		
	}

	@Override
	public Expense updatePartially(Expense expense, int expenseId) {
		Expense exp = findById(expenseId);
		exp.setPrice(expense.getPrice());
		return expenseRepository.save(exp);
	}

}
