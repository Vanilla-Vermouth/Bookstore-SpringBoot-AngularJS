package com.dbms.bookstore.service;

import com.dbms.bookstore.model.Store;
import com.dbms.bookstore.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class StoreService {
	private StoreRepository storeRepository;
	
	@Autowired
	public StoreService(StoreRepository storeRepository) {
		this.storeRepository = storeRepository;
	}
	
	public List<Store> getAllStores() {
		List<Store> stores = new LinkedList<>();
		this.storeRepository.findAll().forEach(stores::add);
		return stores;
	}
	
	public Store getStoreById(int id) {
		return this.storeRepository.findById(id).orElse(null);
	}
}
