package com.furama.controller;

import com.furama.dto.CustomerDto;
import com.furama.model.Customer;
import com.furama.model.CustomerType;
import com.furama.service.ICustomerService;
import com.furama.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerTypeService customerTypeService;
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/customer")
    public String goListCustomer(Model model,
                                 @PageableDefault(5) Pageable pageable,
                                 @RequestParam Optional<String> key) {
        for (Sort.Order order : pageable.getSort()) {
            model.addAttribute("sortValue", order.getProperty());
        }
        String keyWork = key.orElse("");
        Page<Customer> customerPage = customerService.findAllByName(pageable, keyWork);
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerPage", customerPage);
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("keyWork", keyWork);
        return "customer/listCustomer";
    }

    @GetMapping("/customer/createCustomer")
    public String showCreateCustomer(Model model) {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/createCustomer";
    }

    @PostMapping("/createCustomer")
    public String createCustomer(@ModelAttribute
                                 @Valid CustomerDto customerDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "customer/createCustomer";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);

        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customerDto", customerDto);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Register successfully!");
        return "redirect:/customer";
    }
}
