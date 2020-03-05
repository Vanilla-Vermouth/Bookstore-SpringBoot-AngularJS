
package com.dbms.bookstore.model;

import javax.persistence.*;

@Entity

public class ProductId {
	@Id
	private int id;
	private String name;
	
	
	public ProductId() {
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
