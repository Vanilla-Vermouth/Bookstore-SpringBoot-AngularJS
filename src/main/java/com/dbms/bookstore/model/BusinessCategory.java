package com.dbms.bookstore.model;

import javax.persistence.*;

@Entity
@Table(name = "business_category")
public class BusinessCategory {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "category")
	private String category;
	
	public BusinessCategory() {
	}
	
	public BusinessCategory(String category) {
		this.category = category;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
}
