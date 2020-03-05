package com.dbms.bookstore.repository;

import com.dbms.bookstore.model.Transaction;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, String> {
	@Query("select t from Transaction t where t.customer_id = ?1")
	List<Transaction> findByCustomerId(int customer_id);

	@Transactional
	@Modifying
	@Query("delete from Transaction t where t.customer_id=?1")
	void deleteByCustomer_id(int id);
}
