package com.dbms.bookstore.api;

import com.dbms.bookstore.model.*;
import com.dbms.bookstore.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	private ZipService zipService;
	private CityService cityService;
	private CustomerService customerService;
	private ProductService productService;
	private SalespersonService salespersonService;
	private HomeCustomerService homeCustomerService;
	private BusinessCustomerService businessCustomerService;
	private TransactionService transactionService;
	private ProductCategoryService productCategoryService;
	private BusinessCategoryService businessCategoryService;
	private ProductProfitService productProfitService;
	
	@Autowired
	public ApiController(ZipService zipService, CityService cityService, CustomerService customerService, ProductService productService, SalespersonService salespersonService, HomeCustomerService homeCustomerService, BusinessCustomerService businessCustomerService, TransactionService transactionService, ProductCategoryService productCategoryService, BusinessCategoryService businessCategoryService, ProductProfitService productProfitService) {
		this.zipService = zipService;
		this.cityService = cityService;
		this.customerService = customerService;
		this.productService = productService;
		this.salespersonService = salespersonService;
		this.homeCustomerService = homeCustomerService;
		this.businessCustomerService = businessCustomerService;
		this.transactionService = transactionService;
		this.productCategoryService = productCategoryService;
		this.businessCategoryService = businessCategoryService;
		this.productProfitService = productProfitService;
	}

	@GetMapping("/products/profit")
	public List<ProductProfit> getAll() {
		return this.productProfitService.findAll();
	}

	@GetMapping("/salesperson")
	public List<Salesperson> getAllSalespeople() {
		return this.salespersonService.getAllSalespeople();
	}
	
	@GetMapping("/salesperson/username/{username}")
	public Salesperson getSalesperson(@PathVariable("username") String username) {
		return this.salespersonService.getSalespersonByUsername(username);
	}
	
	@GetMapping("/zips")
	public List<Zip> getAllZips() {
		return this.zipService.getAllZips();
	}
	
	@GetMapping("/customers/history")
	public List<CustomerHistory> getCustomerHistory(HttpServletRequest request) {
		int id = (int) request.getSession().getAttribute("id");
		return this.transactionService.getCustomerHistory(id);
	}
	
	@GetMapping("/cities")
	public List<City> getAllCities() {
		return this.cityService.getAllCities();
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return this.customerService.getAllCustomers();
	}
	
	@GetMapping("/customers/id/{id}")
	public Customer getCustomerById(@PathVariable("id") int id) {
		return this.customerService.getCustomerById(id);
	}
	
	@GetMapping("/customers/username/{username}")
	public Customer getCustomerByUsername(@PathVariable("username") String username) {
		return this.customerService.getCustomerByUsername(username);
	}
	
	@GetMapping("/home/id/{id}")
	public HomeCustomer getHomeCustomerById(@PathVariable("id") int id) {
		return this.homeCustomerService.getHomeCustomerById(id);
	}
	
	@GetMapping("/business/id/{id}")
	public BusinessCustomer getBusinessCustomerById(@PathVariable("id") int id) {
		return this.businessCustomerService.getBusinessCustomerById(id);
	}
	
	@GetMapping("/business/categories")
	public List<BusinessCategory> getAllBusinessCategories() {
		return this.businessCategoryService.getAllCategories();
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return this.productService.getAllProducts();
	}
	
	@GetMapping("/products/id/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		return this.productService.getProductById(id);
	}
	
	@GetMapping("/products/name/{name}")
	public Product getProductByName(@PathVariable("name") String name) {
		return this.productService.getProductByName(name);
	}
	
	@GetMapping("/products/store_id/{store_id}")
	public List<Product> getProductsByStoreId(@PathVariable("store_id") int store_id) {
		return this.productService.getProductsByStoreId(store_id);
	}
	
	@GetMapping("/products/categories")
	public List<ProductCategory> getProductCategories() {
		return this.productCategoryService.getAllCategories();
	}
	
	@GetMapping("/products/category_id/{category_id}")
	public List<Product> getProductsByCategoryId(@PathVariable("category_id") int category_id) {
		return this.productService.getProductsByCategoryId(category_id);
	}
	
	@GetMapping("products/valid")
	public List<Product> getValidProducts() {
		return this.productService.getValidProducts();
	}


}
