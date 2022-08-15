package com.customer.repository;

import com.customer.model.Customer;

import java.util.List;

public interface ICustomerRepository {

    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(Integer id);

    void edit(Customer customer);

    void delete(Integer id);

    List<Customer> searchByName(String search);
}
