package com.dbms.bookstore.model;

import javax.persistence.*;

@Entity
@Table(name = "products_category")
public class ProductCategory {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "category")
	private String category;
	
	public ProductCategory() {
	}
	
	public ProductCategory(String category) {
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
