package com.candidjava.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.candidjava.spring.bean.Expense;
import com.candidjava.spring.bean.User;
import com.candidjava.spring.service.ExpenseService;

@RestController
@RequestMapping(value = { "/expense" })
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;

	@PostMapping(value = "/create", headers = "Accept=application/json")
	public ResponseEntity<Void> createExpense(@RequestBody Expense expense, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Expense " + expense.getExpenseType() + expense.getDate() + expense.getPrice()
				+ expense.getNumberOfItems() + expense.getTotal() + expense.getByWhom());
		expenseService.createExpense(expense);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/expense/{expenseId}").buildAndExpand(expense.getExpenseId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}

	@GetMapping(value = "/{expenseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Expense> getExpenseById(@PathVariable("expenseId") int expenseId) {
		System.out.println("Fetching Expense with id " + expenseId);
		Expense expense = expenseService.findById(expenseId);
		if (expense == null) {
			return new ResponseEntity<Expense>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Expense>(expense, HttpStatus.OK);
	}

	@GetMapping(value = "/get", headers = "Accept=application/json")
	public List<Expense> getAllUser() {
		List<Expense> tasks = expenseService.getExpense();
		return tasks;
	}

	@PutMapping(value = "/update", headers = "Accept=application/json")
	public ResponseEntity<String> updateExpense(@RequestBody Expense currentExpense) {
		System.out.println("sd");
		Expense expense = expenseService.findById(currentExpense.getExpenseId());
		if (expense == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		expenseService.update(currentExpense, currentExpense.getExpenseId());
		return new ResponseEntity<String>(HttpStatus.OK);

	}

	@DeleteMapping(value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<Expense> deleteExpense(@PathVariable("id") int expenseId) {
		Expense expense = expenseService.findById(expenseId);
		if (expense == null) {
			return new ResponseEntity<Expense>(HttpStatus.NOT_FOUND);
		}
		expenseService.deleteUserById(expenseId);
		return new ResponseEntity<Expense>(HttpStatus.NO_CONTENT);
	}

	@PatchMapping(value = "/{expenseId}", headers = "Accept=application/json")
	public ResponseEntity<Expense> updateExpensePartially(@PathVariable("expenseId") int expenseId,
			@RequestBody Expense currentExpense) {
		Expense expense = expenseService.findById(expenseId);
		if (expense == null) {
			return new ResponseEntity<Expense>(HttpStatus.NOT_FOUND);
		}
		Expense exp = expenseService.updatePartially(currentExpense, expenseId);
		return new ResponseEntity<Expense>(exp, HttpStatus.OK);
	}

}
