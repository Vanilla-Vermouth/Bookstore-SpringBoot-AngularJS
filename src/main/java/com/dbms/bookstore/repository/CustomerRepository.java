package com.dbms.bookstore.repository;

import com.dbms.bookstore.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	Customer findByUsername(String username);
}
