package com.dbms.bookstore.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "store_id")
	private int store_id;
	@Column(name = "image_url")
	private String image_url;
	@Column(name = "inventory_amount")
	private int inventory_amount;
	@Column(name = "price")
	private int price;
	@Column(name = "category_id")
	private int category_id;

	public Product() {
	}

	public Product(String name, int store_id, String image_url, int inventory_amount, int price, int category_id) {
		this.name = name;
		this.store_id = store_id;
		this.image_url = image_url;
		this.inventory_amount = inventory_amount;
		this.price = price;
		this.category_id = category_id;
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

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public int getInventory_amount() {
		return inventory_amount;
	}

	public void setInventory_amount(int inventory_amount) {
		this.inventory_amount = inventory_amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
}
