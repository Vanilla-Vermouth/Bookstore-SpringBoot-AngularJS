package com.dbms.bookstore.repository;

import com.dbms.bookstore.model.ProductProfit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.dbms.bookstore.model.Product;
import com.dbms.bookstore.model.Transaction;

import java.util.List;

@Repository
public interface ProductProfitRepository extends CrudRepository<ProductProfit, Integer> {
    @Query("select p.id as id, sum(t.quantity * p.price) as profit,p.name as name,s.id as storeid from Product p,Store s, Transaction t where p.id = t.product_id and p.store_id = s.id group by p.id")
    List<Object[]> getAll();
}
