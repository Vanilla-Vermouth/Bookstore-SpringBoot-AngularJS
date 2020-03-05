package com.dbms.bookstore.repository;

import com.dbms.bookstore.model.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends CrudRepository<Store, Integer> {
}
