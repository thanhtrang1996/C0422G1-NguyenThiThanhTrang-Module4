package com.customer.controller;

import com.customer.model.Customer;
import com.customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/list")
    public String goCustomer(Model model) {
        List<Customer> customerList = this.customerService.findAll();
        model.addAttribute("customerList", customerList);
        return "customer";
    }

    @GetMapping("/create")
    public String goCreate() {
        return "create";
    }

    @PostMapping("/create")
    public String saveCustomer(@RequestParam Integer id,
                               @RequestParam String name,
                               @RequestParam Integer age) {
        Customer customer = new Customer(id, name, age);
        this.customerService.save(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/edit")
    public String goEdit(@RequestParam Integer id, Model model) {
        Customer customer = this.customerService.findById(id);
        model.addAttribute("customer", customer);
        return "edit";
    }

    @PostMapping("/edit")
    public String editCustomer(@RequestParam Integer id,
                               @RequestParam String name,
                               @RequestParam Integer age) {
        Customer customer = new Customer(id, name, age);
        this.customerService.edit(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam Integer id) {
        this.customerService.delete(id);
        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomer(@RequestParam String search,
                                 Model model) {
        List<Customer> customerList = this.customerService.searchByName(search);
        model.addAttribute("customerList", customerList);
        model.addAttribute("search", search);
        return "customer";
    }
}
