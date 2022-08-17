package com.employee.controller;

import com.employee.model.Employee;
import com.employee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;


    @GetMapping("list")
    public String employee(Model model) {
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employeeList", employeeList);
        return "employee";
    }

    @GetMapping("/create")
    public String goCreate() {
        return "create";
    }

    @PostMapping("/create")
    public String saveEmployee(@RequestParam String id,
                               @RequestParam String name,
                               @RequestParam String contactNumber) {
        Employee employee = new Employee(id, name, contactNumber);
        employeeService.saveEmployee(employee);
        return "redirect:/employee/list";
    }
}
