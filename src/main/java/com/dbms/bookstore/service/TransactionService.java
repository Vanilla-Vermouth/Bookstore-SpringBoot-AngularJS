package com.dbms.bookstore.service;

import com.dbms.bookstore.model.Customer;
import com.dbms.bookstore.model.CustomerHistory;
import com.dbms.bookstore.model.Product;
import com.dbms.bookstore.model.Transaction;
import com.dbms.bookstore.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TransactionService {
	private TransactionRepository transactionRepository;
	private ProductService productService;
	
	@Autowired
	public TransactionService(TransactionRepository transactionRepository, ProductService productService) {
		this.transactionRepository = transactionRepository;
		this.productService = productService;
	}
	
	public List<Transaction> getAllTransactions() {
		List<Transaction> transactions = new LinkedList<>();
		this.transactionRepository.findAll().forEach(transactions::add);
		return transactions;
	}
	
	public List<Transaction> getTransactionsByCustomerId(int id) {
		List<Transaction> transactions = new LinkedList<>();
		transactions.addAll(this.transactionRepository.findByCustomerId(id));
		return transactions;
	}
	
	public Transaction save(Transaction transaction) {
		return this.transactionRepository.save(transaction);
	}
	
	public List<CustomerHistory> getCustomerHistory(int id) {
		List<Transaction> transactions = getTransactionsByCustomerId(id);
		List<CustomerHistory> customerHistories = new LinkedList<>();
		for (Transaction transaction : transactions) {
			Product product = this.productService.getProductById(transaction.getProduct_id());
			CustomerHistory customerHistory = new CustomerHistory();
			customerHistory.setOrder_number(transaction.getOrder_number());
			customerHistory.setName(product.getName());
			customerHistory.setPrice(product.getPrice());
			customerHistory.setQuantity(transaction.getQuantity());
			customerHistory.setStore_id(transaction.getStore_id());
			customerHistory.setDate_time(transaction.getDate_time());
			customerHistories.add(customerHistory);
		}
		return customerHistories;
	}
	public void deleteTransactions(int id){
		this.transactionRepository.deleteByCustomer_id(id);
	}
}
