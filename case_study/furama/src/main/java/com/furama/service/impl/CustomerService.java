package com.furama.service.impl;

import com.furama.model.Customer;
import com.furama.repository.ICustomerRepository;
import com.furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAllByName(Pageable pageable, String keyWork) {
        return customerRepository.findAllByNameContaining(pageable,keyWork);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        customerRepository.delete(findById(id));
    }
}
