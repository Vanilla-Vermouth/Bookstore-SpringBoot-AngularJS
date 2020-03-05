package com.dbms.bookstore.repository;

import com.dbms.bookstore.model.HomeCustomer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeCustomerRepository extends CrudRepository<HomeCustomer, Integer> {
}
