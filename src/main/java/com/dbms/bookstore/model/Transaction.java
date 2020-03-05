package com.dbms.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class Transaction {
	@Id
	@Column(name = "order_number")
	private String order_number;
	@Column(name = "date_time")
	private String date_time;
	@Column(name = "store_id")
	private int store_id;
	@Column(name = "product_id")
	private int product_id;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "customer_id")
	private int customer_id;
	
	public Transaction() {
	}
	
	public Transaction(String order_number, String date_time, int store_id, int product_id, int quantity, int customer_id) {
		this.order_number = order_number;
		this.date_time = date_time;
		this.store_id = store_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.customer_id = customer_id;
	}
	
	public String getOrder_number() {
		return order_number;
	}
	
	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}
	
	public String getDate_time() {
		return date_time;
	}
	
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	
	public int getStore_id() {
		return store_id;
	}
	
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	
	public int getProduct_id() {
		return product_id;
	}
	
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getCustomer_id() {
		return customer_id;
	}
	
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	
	public String getOrderNumber() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	public String getTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// set date format
		return df.format(new Date());// new Date() -> get current system time
	}
}
