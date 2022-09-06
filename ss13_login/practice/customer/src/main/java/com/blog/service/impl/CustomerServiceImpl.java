package com.blog.service.impl;

import com.blog.entity.Customer;
import com.blog.repository.CustomerRepository;
import com.blog.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        customerRepository.save(theCustomer);
    }
    @Override
    public Customer getCustomer(int theId) {
        return customerRepository.findById(theId).orElse(null);
    }

    @Override
    public void deleteCustomer(int theId) {
        customerRepository.deleteById(theId);
    }
    @Override
    public List<Customer> findCustomersByFirstName(String name) {
        return customerRepository.findCustomersByFirstNameCustomer(name);
    }
}