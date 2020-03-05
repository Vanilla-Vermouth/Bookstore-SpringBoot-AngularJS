package com.dbms.bookstore.service;

import com.dbms.bookstore.model.HomeCustomer;
import com.dbms.bookstore.repository.HomeCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
@Transactional
public class HomeCustomerService {
	private HomeCustomerRepository homeCustomerRepository;
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	public HomeCustomerService(HomeCustomerRepository homeCustomerRepository, EntityManager em) {
		this.homeCustomerRepository = homeCustomerRepository;
		this.em = em;
	}
	
	public HomeCustomer getHomeCustomerById(int id) {
		return this.homeCustomerRepository.findById(id).orElse(null);
	}
	
	public HomeCustomer save(HomeCustomer homeCustomer) {
		return this.homeCustomerRepository.save(homeCustomer);
	}
	
	public HomeCustomer update(HomeCustomer homeCustomer) {
		return em.merge(homeCustomer);
	}
}
