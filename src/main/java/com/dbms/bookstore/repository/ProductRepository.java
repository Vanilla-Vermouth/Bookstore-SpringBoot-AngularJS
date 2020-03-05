package com.dbms.bookstore.repository;

import com.dbms.bookstore.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	Product findByName(String name);
	
	@Query("select p from Product p where p.store_id = ?1")
	List<Product> findByStoreId(int store_id);
	
	@Query("select p from Product p where p.category_id = ?1")
	List<Product> findByCategoryId(int category_id);
	
	@Query("select p from Product p where p.inventory_amount > 0")
	List<Product> findByInventoryAmount();

	@Query("select p.id from Product p where p.inventory_amount > 0")
	List<Product> findByInventoryAmountid();

	@Transactional
	@Modifying
	@Query("update Product p set p.inventory_amount=0 where p.id=?1")
	void DeleteById(int id);

}
