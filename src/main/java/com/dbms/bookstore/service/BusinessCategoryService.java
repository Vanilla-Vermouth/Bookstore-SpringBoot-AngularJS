package com.dbms.bookstore.service;

import com.dbms.bookstore.model.BusinessCategory;
import com.dbms.bookstore.repository.BusinessCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class BusinessCategoryService {
	private BusinessCategoryRepository businessCategoryRepository;
	
	@Autowired
	public BusinessCategoryService(BusinessCategoryRepository businessCategoryRepository) {
		this.businessCategoryRepository = businessCategoryRepository;
	}
	
	public List<BusinessCategory> getAllCategories() {
		List<BusinessCategory> businessCategories = new LinkedList<>();
		this.businessCategoryRepository.findAll().forEach(businessCategories::add);
		return businessCategories;
	}
}
