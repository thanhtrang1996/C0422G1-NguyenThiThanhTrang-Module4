package com.furama.controller;

import com.furama.model.Employee;
import com.furama.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RequestMapping("/employeeRest")
@RestController
public class EmployeeRestController {
    @Autowired
    private IEmployeeService employeeService;
    @GetMapping("/list")
    public ResponseEntity<Page<Employee>> goPage(@PageableDefault(5)Pageable pageable,
                                                 @RequestParam Optional<String> name){
        String keyName = name.orElse("");
        Page<Employee>employeePage = employeeService.findByName(pageable,keyName);
        if (!employeePage.hasContent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeePage,HttpStatus.OK);
    }
    @PostMapping("/createEmployee")
    public ResponseEntity<List<Employee>> goCreate(@RequestBody Employee employee){
        employeeService.save(employee);
        return new ResponseEntity<>(employeeService.findAll(),HttpStatus.OK);
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> goDelete(@PathVariable Integer id) {
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
