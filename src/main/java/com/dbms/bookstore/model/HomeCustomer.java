package com.dbms.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "home")
public class HomeCustomer {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "marriage_status")
	private String marriage_status;
	@Column(name = "gender")
	private String gender;
	@Column(name = "age")
	private int age;
	@Column(name = "income")
	private int income;
	
	public HomeCustomer() {
	}
	
	public HomeCustomer(int id, String marriage_status, String gender, int age, int income) {
		this.id = id;
		this.marriage_status = marriage_status;
		this.gender = gender;
		this.age = age;
		this.income = income;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMarriage_status() {
		return marriage_status;
	}
	
	public void setMarriage_status(String marriage_status) {
		this.marriage_status = marriage_status;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getIncome() {
		return income;
	}
	
	public void setIncome(int income) {
		this.income = income;
	}
}
