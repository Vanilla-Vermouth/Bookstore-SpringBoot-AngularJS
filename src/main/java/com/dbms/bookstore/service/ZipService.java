package com.dbms.bookstore.service;

import com.dbms.bookstore.model.Zip;
import com.dbms.bookstore.repository.ZipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ZipService {
	private ZipRepository zipRepository;
	
	@Autowired
	public ZipService(ZipRepository zipRepository) {
		this.zipRepository = zipRepository;
	}
	
	public List<Zip> getAllZips() {
		List<Zip> zips = new LinkedList<>();
		this.zipRepository.findAll().forEach(zips::add);
		return zips;
	}
}
