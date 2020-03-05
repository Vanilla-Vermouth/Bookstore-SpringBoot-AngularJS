package com.dbms.bookstore.repository;

import com.dbms.bookstore.model.Salesperson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalespersonRepository extends CrudRepository<Salesperson, Integer> {
	Salesperson findByUsername(String username);
}
