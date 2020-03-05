package com.dbms.bookstore.model;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
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
	@Column(name = "kind")
	private String kind;
	
	public Customer() {
	}
	
	public Customer(String username, String password, String name, int zip_code, String street, String kind) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.zip_code = zip_code;
		this.street = street;
		this.kind = kind;
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
	
	public String getKind() {
		return kind;
	}
	
	public void setKind(String kind) {
		this.kind = kind;
	}
}
