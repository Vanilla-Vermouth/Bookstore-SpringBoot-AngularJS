package com.dbms.bookstore.repository;

import com.dbms.bookstore.model.Zip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipRepository extends CrudRepository<Zip, Integer> {
}
