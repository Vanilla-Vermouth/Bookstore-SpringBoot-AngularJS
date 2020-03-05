package com.dbms.bookstore.controller;

import com.dbms.bookstore.model.Customer;
import com.dbms.bookstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class CustomerController {
	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping
	public String login(HttpServletRequest request) {
		if (request.getSession().getAttribute("name") != null) {
			return "redirect:/books";
		}
		return "login";
	}
	
	@PostMapping
	public String login(Model model, @Valid Customer customer, HttpServletRequest request) {
		String username = customer.getUsername();
		String password = customer.getPassword();
		
		try {
			Customer result = this.customerService.getCustomerByUsername(username);
			if (password.equals(result.getPassword())) {
				HttpSession session = request.getSession();
				session.setAttribute("name", result.getName());
				session.setAttribute("id", result.getId());
				return "redirect:/books";
			} else {
				model.addAttribute("invalid", true);
			}
		} catch (NullPointerException ex) {
			model.addAttribute("invalid", true);
		}
		
		return "login";
	}
	
}
