package com.furama.service;

import com.furama.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findAllByName(Pageable pageable, String keyWork);

    void save(Customer customer);
}
