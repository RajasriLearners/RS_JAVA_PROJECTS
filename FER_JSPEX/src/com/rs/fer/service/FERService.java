package com.rs.fer.service;

import java.util.List;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.bean.User;

public interface FERService {
	int login(String userName,String password);
	boolean registration(User user);
	//boolean AddUser(User user);
	boolean addExpense(Expense expense);
	boolean deleteExpense(int expenseId);
	boolean editExpense(Expense expense);
	Expense getExpense(int expenseId);
	List<Expense>getExpenseReport(String expenseType,String fromDate,String toDate,int userId);
	List<Expense>getExpenses(int userId);
	boolean resetPassword(int userId,String oldPassword,String newPassword);
	PersonalInfo getPersonalInfo(int userId);
	boolean updatePersonalInfo(User user, Address address);	
	
	

}
