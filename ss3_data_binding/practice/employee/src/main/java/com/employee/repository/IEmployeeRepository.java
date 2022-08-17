package com.employee.repository;

import com.employee.model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> findAll();

    void saveEmployee(Employee employee);
}
