package com.furama.service;

import com.furama.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    void save(Employee employee);

    Employee findById(Integer id);

    void delete(Integer id);

    Page<Employee> findByName(Pageable pageable, String keyName);

}
