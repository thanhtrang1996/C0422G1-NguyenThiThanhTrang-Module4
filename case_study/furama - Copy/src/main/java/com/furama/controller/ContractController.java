package com.furama.controller;

import com.furama.model.AttachFacility;
import com.furama.model.Customer;
import com.furama.model.Employee;
import com.furama.model.Facility;
import com.furama.service.IAttachFacilityService;
import com.furama.service.ICustomerService;
import com.furama.service.IEmployeeService;
import com.furama.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class ContractController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @Autowired
    private IEmployeeService employeeService;

    @ModelAttribute("customerList")
    public List<Customer> getAllCustomer() {
        return this.customerService.findAll();
    }

    @ModelAttribute("facilityList")
    public List<Facility> getAllFacility() {
        return this.facilityService.findAll();
    }

    @ModelAttribute("attachFacilityList")
    public List<AttachFacility> getAllAttachFacility() {
        return this.attachFacilityService.findAll();
    }

    @ModelAttribute("employeeList")
    public List<Employee> getAllEmployee () {
        return this.employeeService.findAll();
    }

    @GetMapping("/contract")
    public String goContract() {
        return "contract/listContract";
    }
}
