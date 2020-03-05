package com.dbms.bookstore.service;

import com.dbms.bookstore.model.Product;
import com.dbms.bookstore.model.ProductId;
import com.dbms.bookstore.repository.ProductRepository;
import com.dbms.bookstore.repository.ProductIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProductService {
	private ProductRepository productRepository;
	private ProductIdRepository productIdRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository,ProductIdRepository productIdRepository) {
		this.productRepository = productRepository;
		this.productIdRepository=productIdRepository;
	}
	
	public List<Product> getAllProducts() {
		List<Product> products = new LinkedList<>();
		this.productRepository.findAll().forEach(products::add);
		return products;
	}
	public List<ProductId> getProductsId() {
		List<ProductId> productsid = new LinkedList<>();
		this.productIdRepository.findAll().forEach(productsid::add);
		return productsid;
	}
	public ProductId getProductnameById(int id) {
		return this.productIdRepository.findnameById(id);
	}

	public Product getProductById(int id) {
		return this.productRepository.findById(id).orElse(null);
	}
	
	public Product getProductByName(String name) {
		return this.productRepository.findByName(name);
	}
	
	public List<Product> getProductsByStoreId(int store_id) {
		return this.productRepository.findByStoreId(store_id);
	}
	
	public List<Product> getProductsByCategoryId(int category_id) {
		return this.productRepository.findByCategoryId(category_id);
	}
	public List<Product> getValidProductsid() {
		return this.productRepository.findByInventoryAmountid();
	}
	
	public List<Product> getValidProducts() {
		return this.productRepository.findByInventoryAmount();
	}
	public Product save(Product product){
		return this.productRepository.save(product);
	}
	public void deleleBook(int id){
		this.productRepository.DeleteById(id);
	}
}
