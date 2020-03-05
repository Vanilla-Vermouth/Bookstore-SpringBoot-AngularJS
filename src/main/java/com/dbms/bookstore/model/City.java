package com.dbms.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {
	@Id
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	
	public City() {
	}
	
	public City(String city, String state) {
		this.city = city;
		this.state = state;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
}
