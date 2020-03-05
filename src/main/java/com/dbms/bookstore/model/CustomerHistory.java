package com.dbms.bookstore.model;

public class CustomerHistory {
	private String order_number;
	private String name;
	private int price;
	private int quantity;
	private int store_id;
	private String date_time;
	
	public CustomerHistory() {
	}
	
	public CustomerHistory(String order_number, String name, int price, int quantity, int store_id, String date_time) {
		this.order_number = order_number;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.store_id = store_id;
		this.date_time = date_time;
	}
	
	public String getOrder_number() {
		return order_number;
	}
	
	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getStore_id() {
		return store_id;
	}
	
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	
	public String getDate_time() {
		return date_time;
	}
	
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
}
