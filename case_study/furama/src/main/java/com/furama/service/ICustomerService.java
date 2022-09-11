package com.furama.service;

import com.furama.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAllByName(Pageable pageable, String keyWork);

    void save(Customer customer);

    Customer findById(Integer id);

    void delete(Integer id);

    List<Customer> findAll();
}
