package com.dbms.bookstore.repository;

import com.dbms.bookstore.model.BusinessCustomer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessCustomerRepository extends CrudRepository<BusinessCustomer, Integer> {
}
