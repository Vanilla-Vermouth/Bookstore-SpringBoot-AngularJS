
package com.dbms.bookstore.repository;

import com.dbms.bookstore.model.ProductId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;




@Repository
public interface ProductIdRepository extends CrudRepository<ProductId, Integer> {
    @Query("select  p.id as id ,p.name as name from Product p")
    List getAll();

    @Query("select  p.id as id ,p.name as name from Product p where p.id=?1")
    ProductId findnameById(int id);
}
