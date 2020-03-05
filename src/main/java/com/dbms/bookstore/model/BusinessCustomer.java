package com.dbms.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "business")
public class BusinessCustomer {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "category_id")
	private int category_id;
	@Column(name = "annual_income")
	private int annual_income;
	
	public BusinessCustomer() {
	}
	
	public BusinessCustomer(int id, int category_id, int annual_income) {
		this.id = id;
		this.category_id = category_id;
		this.annual_income = annual_income;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCategory_id() {
		return category_id;
	}
	
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
	public int getAnnual_income() {
		return annual_income;
	}
	
	public void setAnnual_income(int annual_income) {
		this.annual_income = annual_income;
	}
}
