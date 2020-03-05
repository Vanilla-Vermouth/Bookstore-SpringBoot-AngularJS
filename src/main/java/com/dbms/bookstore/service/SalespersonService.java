package com.dbms.bookstore.service;

import com.dbms.bookstore.model.Salesperson;
import com.dbms.bookstore.repository.SalespersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SalespersonService {
	private SalespersonRepository salespersonRepository;
	
	@Autowired
	public SalespersonService(SalespersonRepository salespersonRepository) {
		this.salespersonRepository = salespersonRepository;
	}
	
	public List<Salesperson> getAllSalespeople() {
		List<Salesperson> salespeople = new LinkedList<>();
		this.salespersonRepository.findAll().forEach(salespeople::add);
		return salespeople;
	}
	
	public Salesperson getSalespersonByUsername(String username) {
		return this.salespersonRepository.findByUsername(username);
	}
}
