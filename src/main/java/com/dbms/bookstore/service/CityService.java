package com.dbms.bookstore.service;

import com.dbms.bookstore.model.City;
import com.dbms.bookstore.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CityService {
	private CityRepository cityRepository;
	
	@Autowired
	public CityService(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}
	
	public List<City> getAllCities() {
		List<City> cities = new LinkedList<>();
		this.cityRepository.findAll().forEach(cities::add);
		return cities;
	}
}
