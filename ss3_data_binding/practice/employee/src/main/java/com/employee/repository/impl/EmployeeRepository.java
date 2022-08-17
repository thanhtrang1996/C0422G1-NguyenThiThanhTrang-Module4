package com.employee.repository.impl;

import com.employee.model.Employee;
import com.employee.repository.IEmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository implements IEmployeeRepository {
    private static List<Employee> employeeList = new ArrayList<>();

    static {
        employeeList.add(new Employee("1", "Trang", "12345"));
        employeeList.add(new Employee("2", "Phương", "32445"));
        employeeList.add(new Employee("3", "Nhiên", "98645"));
        employeeList.add(new Employee("4", "Duyên", "35245"));
        employeeList.add(new Employee("5", "Long", "32145"));
    }

    @Override
    public List<Employee> findAll() {
        return employeeList;
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeList.add(employee);
    }
}
