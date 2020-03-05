package com.dbms.bookstore.controller;

import com.dbms.bookstore.model.BusinessCustomer;
import com.dbms.bookstore.model.Customer;
import com.dbms.bookstore.model.HomeCustomer;
import com.dbms.bookstore.service.BusinessCustomerService;
import com.dbms.bookstore.service.CustomerService;
import com.dbms.bookstore.service.HomeCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/personal_info/rest")
public class PersonalInfoRest {
	private CustomerService customerService;
	private HomeCustomerService homeCustomerService;
	private BusinessCustomerService businessCustomerService;
	
	@Autowired
	public PersonalInfoRest(CustomerService customerService, HomeCustomerService homeCustomerService, BusinessCustomerService businessCustomerService) {
		this.customerService = customerService;
		this.homeCustomerService = homeCustomerService;
		this.businessCustomerService = businessCustomerService;
	}
	
	@GetMapping("/customer")
	public Customer getCustomer(HttpServletRequest request) {
		int id = (int) request.getSession().getAttribute("id");
		return this.customerService.getCustomerById(id);
	}
	
	@GetMapping("/home")
	public HomeCustomer getHomeCustomer(HttpServletRequest request) {
		int id = (int) request.getSession().getAttribute("id");
		return this.homeCustomerService.getHomeCustomerById(id);
	}
	
	@GetMapping("/business")
	public BusinessCustomer getBusinessCustomer(HttpServletRequest request) {
		int id = (int) request.getSession().getAttribute("id");
		return this.businessCustomerService.getBusinessCustomerById(id);
	}
}
