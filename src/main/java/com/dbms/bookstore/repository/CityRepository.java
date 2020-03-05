package com.dbms.bookstore.repository;

import com.dbms.bookstore.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, String> {
}
