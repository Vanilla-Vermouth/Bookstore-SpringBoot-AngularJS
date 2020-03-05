package com.dbms.bookstore.model;

import javax.persistence.*;

@Entity
@Table(name = "store")
public class Store {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "zip_code")
	private int zip_code;
	@Column(name = "street")
	private String street;
	@Column(name = "number_of_salespersons")
	private int number_of_salespersons;
	@Column(name = "region_id")
	private int region_id;
	
	public Store() {
	}
	
	public Store(int zip_code, String street, int number_of_salespersons, int region_id) {
		this.zip_code = zip_code;
		this.street = street;
		this.number_of_salespersons = number_of_salespersons;
		this.region_id = region_id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public int getNumber_of_salespersons() {
		return number_of_salespersons;
	}
	
	public void setNumber_of_salespersons(int number_of_salespersons) {
		this.number_of_salespersons = number_of_salespersons;
	}
	
	public int getRegion_id() {
		return region_id;
	}
	
	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}
}
