package com.dbms.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zip")
public class Zip {
	@Id
	@Column(name = "zip_code")
	private int zip_code;
	@Column(name = "city")
	private String city;
	
	public Zip(){}
	
	public Zip(int zip_code, String city) {
		this.zip_code = zip_code;
		this.city = city;
	}
	
	public int getZip_code() {
		return zip_code;
	}
	
	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
}
