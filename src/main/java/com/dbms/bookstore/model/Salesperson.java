package com.dbms.bookstore.model;

import javax.persistence.*;

@Entity
@Table(name = "salespersons")
public class Salesperson {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "name")
	private String name;
	@Column(name = "zip_code")
	private int zip_code;
	@Column(name = "street")
	private String street;
	@Column(name = "email")
	private String email;
	@Column(name = "title_id")
	private String title_id;
	@Column(name = "salary")
	private int salary;
	
	public Salesperson() {
	}
	
	public Salesperson(String username, String password, String name, int zip_code, String street, String email, String title_id, int salary) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.zip_code = zip_code;
		this.street = street;
		this.email = email;
		this.title_id = title_id;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getZip_code() {
		return zip_code;
	}
	
	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTitle_id() {
		return title_id;
	}
	
	public void setTitle_id(String title_id) {
		this.title_id = title_id;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
