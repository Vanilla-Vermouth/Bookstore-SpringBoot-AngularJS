package com.dbms.bookstore.service;

import com.dbms.bookstore.model.Customer;
import com.dbms.bookstore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class CustomerService {
    private CustomerRepository customerRepository;
    @PersistenceContext
    private EntityManager em;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, EntityManager em) {
        this.customerRepository = customerRepository;
        this.em = em;
    }

    public Customer save(Customer customer) {
        return this.customerRepository.save(customer);
    }

    public Customer update(Customer customer) {
        return em.merge(customer);
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new LinkedList<>();
        this.customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    public Customer getCustomerById(int id) {
        return this.customerRepository.findById(id).orElse(null);
    }

    public Customer getCustomerByUsername(String username) {
        return this.customerRepository.findByUsername(username);
    }

    public void deleteCustomer(int id) {
        this.customerRepository.deleteById(id);
    }
}
