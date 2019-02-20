package com.candidjava.spring.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="expenseFER")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Expense {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int expenseId;
	@Column
	private String expenseType;
	@Column
	private String date;
	@Column
	private int price;
	@Column
	private int numberOfItems;
	@Column
	private int total;
	@Column
	private String byWhom;

	public int getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getByWhom() {
		return byWhom;
	}

	public void setByWhom(String byWhom) {
		this.byWhom = byWhom;
	}
	
	
}
