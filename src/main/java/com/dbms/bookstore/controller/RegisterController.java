package com.dbms.bookstore.controller;

import com.dbms.bookstore.model.BusinessCustomer;
import com.dbms.bookstore.model.Customer;
import com.dbms.bookstore.model.HomeCustomer;
import com.dbms.bookstore.service.BusinessCategoryService;
import com.dbms.bookstore.service.BusinessCustomerService;
import com.dbms.bookstore.service.CustomerService;
import com.dbms.bookstore.service.HomeCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/register")
public class RegisterController {
	private CustomerService customerService;
	private BusinessCategoryService businessCategoryService;
	private HomeCustomerService homeCustomerService;
	private BusinessCustomerService businessCustomerService;
	
	@Autowired
	public RegisterController(CustomerService customerService, BusinessCategoryService businessCategoryService, HomeCustomerService homeCustomerService, BusinessCustomerService businessCustomerService) {
		this.customerService = customerService;
		this.businessCategoryService = businessCategoryService;
		this.homeCustomerService = homeCustomerService;
		this.businessCustomerService = businessCustomerService;
	}
	
	@GetMapping
	public String register(Model model) {
		model.addAttribute("business_categories", this.businessCategoryService.getAllCategories());
		return "register";
	}
	
	@PostMapping
	public String register(@ModelAttribute("Customer") Customer customer,
	                       @ModelAttribute("HomeCustomer") HomeCustomer homeCustomer,
	                       @ModelAttribute("BusinessCustomer") BusinessCustomer businessCustomer,
	                       HttpServletRequest request,
	                       RedirectAttributes redirectAttributes) {
		String username = customer.getUsername().trim();
		customer.setUsername(username);
		if (this.customerService.getCustomerByUsername(username) != null) {
			request.getSession().setAttribute("message", 1);
			redirectAttributes.addFlashAttribute("message", "Registration Failed");
			redirectAttributes.addFlashAttribute("failure", "Sorry, username exists.");
			redirectAttributes.addFlashAttribute("link", "javascript:history.back()");
			redirectAttributes.addFlashAttribute("linkName", "Go Back");
			return "redirect:/message";
		} else {
			this.customerService.save(customer);
			if (customer.getKind().equals("home")) {
				homeCustomer.setId(customer.getId());
				this.homeCustomerService.save(homeCustomer);
			} else {
				businessCustomer.setId(customer.getId());
				this.businessCustomerService.save(businessCustomer);
			}
			request.getSession().setAttribute("message", 1);
			redirectAttributes.addFlashAttribute("message", "Registration Successful");
			redirectAttributes.addFlashAttribute("success", "success");
			redirectAttributes.addFlashAttribute("link", "/login");
			redirectAttributes.addFlashAttribute("linkName", "Go to login page");
			return "redirect:/message";
		}
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute("Customer") Customer customer,
	                     @ModelAttribute("HomeCustomer") HomeCustomer homeCustomer,
	                     @ModelAttribute("BusinessCustomer") BusinessCustomer businessCustomer,
	                     HttpServletRequest request,
	                     RedirectAttributes redirectAttributes) {
		customer.setUsername(customer.getUsername().trim());
		this.customerService.update(customer);
		if (customer.getKind().equals("home")) {
			homeCustomer.setId(customer.getId());
			this.homeCustomerService.update(homeCustomer);
		} else {
			businessCustomer.setId(customer.getId());
			this.businessCustomerService.update(businessCustomer);
		}
		request.getSession().setAttribute("message", 1);
		redirectAttributes.addFlashAttribute("message", "Update Personal Information Successfully");
		redirectAttributes.addFlashAttribute("success", "success");
		redirectAttributes.addFlashAttribute("link", "/books");
		redirectAttributes.addFlashAttribute("linkName", "Back to homepage");
		return "redirect:/message";
	}
}
