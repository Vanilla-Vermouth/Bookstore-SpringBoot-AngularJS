package com.dbms.bookstore.service;

import com.dbms.bookstore.model.BusinessCustomer;
import com.dbms.bookstore.repository.BusinessCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
@Transactional
public class BusinessCustomerService {
	private BusinessCustomerRepository businessCustomerRepository;
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	public BusinessCustomerService(BusinessCustomerRepository businessCustomerRepository, EntityManager em) {
		this.businessCustomerRepository = businessCustomerRepository;
		this.em = em;
	}
	
	public BusinessCustomer getBusinessCustomerById(int id) {
		return this.businessCustomerRepository.findById(id).orElse(null);
	}
	
	public BusinessCustomer save(BusinessCustomer businessCustomer) {
		return this.businessCustomerRepository.save(businessCustomer);
	}
	
	public BusinessCustomer update(BusinessCustomer businessCustomer) {
		return em.merge(businessCustomer);
	}
}
