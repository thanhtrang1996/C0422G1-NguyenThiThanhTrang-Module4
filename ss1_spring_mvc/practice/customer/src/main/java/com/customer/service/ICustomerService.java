package com.customer.service;

import com.customer.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(Integer id);

    void edit(Customer customer);

    void delete(Integer id);

    List<Customer> searchByName(String search);
}
