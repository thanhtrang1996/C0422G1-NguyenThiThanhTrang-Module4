package com.blog.service;

import com.blog.entity.Customer;

import java.util.List;


public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int theId) ;

    void deleteCustomer(int theId) ;

    List<Customer> findCustomersByFirstName(String name);
}