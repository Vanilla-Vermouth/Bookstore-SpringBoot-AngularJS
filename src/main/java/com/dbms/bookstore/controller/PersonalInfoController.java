package com.dbms.bookstore.controller;

import com.dbms.bookstore.model.Customer;
import com.dbms.bookstore.service.BusinessCategoryService;
import com.dbms.bookstore.service.BusinessCustomerService;
import com.dbms.bookstore.service.CustomerService;
import com.dbms.bookstore.service.HomeCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/personal_info")
public class PersonalInfoController {
	private BusinessCategoryService businessCategoryService;
	
	@Autowired
	public PersonalInfoController(BusinessCategoryService businessCategoryService) {
		this.businessCategoryService = businessCategoryService;
	}
	
	@GetMapping
	public String getInfo(Model model, HttpServletRequest request) {
		if (request.getSession().getAttribute("id") == null)
			return "redirect:/login";
		else {
			model.addAttribute("name", request.getSession().getAttribute("name"));
			model.addAttribute("business_categories", this.businessCategoryService.getAllCategories());
			return "personal_info";
		}
	}
}
