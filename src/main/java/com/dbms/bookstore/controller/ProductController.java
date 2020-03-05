package com.dbms.bookstore.controller;

import com.dbms.bookstore.model.Transaction;
import com.dbms.bookstore.service.ProductService;
import com.dbms.bookstore.service.TransactionService;
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
@RequestMapping("/books")
public class ProductController {
	private ProductService productService;
	private TransactionService transactionService;
	
	@Autowired
	public ProductController(ProductService productService, TransactionService transactionService) {
		this.productService = productService;
		this.transactionService = transactionService;
	}
	
	@GetMapping
	public String getAllProducts(Model model, HttpServletRequest request) {
		model.addAttribute("products", this.productService.getAllProducts());
		if (request.getSession().getAttribute("name") != null)
			model.addAttribute("name", request.getSession().getAttribute("name"));
		return "books";
	}
	
	@PostMapping("/buy")
	public String buy(@ModelAttribute("Product") Transaction transaction, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		if (request.getSession().getAttribute("id") == null)
			return "redirect:/login";
		
		int amount = this.productService.getProductById(transaction.getProduct_id()).getInventory_amount();
		if (amount < transaction.getQuantity()) {
			request.getSession().setAttribute("message", 1);
			redirectAttributes.addFlashAttribute("message", "Payment Failed");
			redirectAttributes.addFlashAttribute("failure", "Purchase quantity is greater than inventory amount.");
			redirectAttributes.addFlashAttribute("link", "javascript:history.back()");
			redirectAttributes.addFlashAttribute("linkName", "Go Back");
			return "redirect:/message";
		}
		
		transaction.setOrder_number(transaction.getOrderNumber());
		transaction.setDate_time(transaction.getTime());
		transaction.setCustomer_id((int) request.getSession().getAttribute("id"));
		this.transactionService.save(transaction);
		request.getSession().setAttribute("message", 1);
		redirectAttributes.addFlashAttribute("message", "Payment Successful");
		redirectAttributes.addFlashAttribute("success", "success");
		redirectAttributes.addFlashAttribute("link", "/books");
		redirectAttributes.addFlashAttribute("linkName", "Back to homepage");
		return "redirect:/message";
	}
	
}
