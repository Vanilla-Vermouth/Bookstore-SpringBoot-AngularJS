package com.dbms.bookstore.service;

import com.dbms.bookstore.model.ProductCategory;
import com.dbms.bookstore.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProductCategoryService {
	private ProductCategoryRepository productCategoryRepository;
	
	@Autowired
	public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
		this.productCategoryRepository = productCategoryRepository;
	}
	
	public List<ProductCategory> getAllCategories() {
		List<ProductCategory> productCategories = new LinkedList<>();
		this.productCategoryRepository.findAll().forEach(productCategories::add);
		return productCategories;
	}
}
