package com.dbms.bookstore.repository;

import com.dbms.bookstore.model.BusinessCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessCategoryRepository extends CrudRepository<BusinessCategory, Integer> {
}
