package com.customer.service.impl;

import com.customer.model.Customer;
import com.customer.repository.ICustomerRepository;
import com.customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return this.customerRepository.findById(id);
    }

    @Override
    public void edit(Customer customer) {
        this.customerRepository.edit(customer);
    }

    @Override
    public void delete(Integer id) {
        this.customerRepository.delete(id);
    }

    @Override
    public List<Customer> searchByName(String search) {
        return this.customerRepository.searchByName(search);
    }
}
