package com.dbms.bookstore.controller;

import com.dbms.bookstore.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/history")
public class CustomerHistoryController {
	private TransactionService transactionService;
	
	@Autowired
	public CustomerHistoryController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@GetMapping
	public String getHistory(Model model, HttpServletRequest request) {
		if (request.getSession().getAttribute("id") == null) return "redirect:/login";
		int id = (int) request.getSession().getAttribute("id");
		model.addAttribute("name", request.getSession().getAttribute("name"));
		model.addAttribute("histories", this.transactionService.getCustomerHistory(id));
		return "history";
	}
}
