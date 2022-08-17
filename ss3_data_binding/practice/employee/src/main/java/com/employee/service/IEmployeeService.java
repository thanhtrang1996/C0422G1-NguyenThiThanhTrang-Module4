package com.employee.service;

import com.employee.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    void saveEmployee(Employee employee);
}
