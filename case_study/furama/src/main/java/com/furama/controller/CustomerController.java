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
        String keyWord = key.orElse("");
        Page<Customer> customerPage = customerService.findAllByName(pageable, keyWord);
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerPage", customerPage);
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("keyWord", keyWord);
        return "customer/listCustomer";
    }

    @GetMapping("/createCustomer")
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
            List<CustomerType> customerTypeList = customerTypeService.findAll();
            model.addAttribute("customerTypeList", customerTypeList);
            return "customer/createCustomer";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        model.addAttribute("customerDto", customerDto);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Register successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/updateCustomer")
    public String showUpdateCustomer(@RequestParam Integer id, Model model) {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customerDto", customerService.findById(id));
        return "customer/updateCustomer";

    }

    @PostMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute
                                 @Valid CustomerDto customerDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Customer customer, Model model) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            List<CustomerType> customerTypeList = customerTypeService.findAll();
            model.addAttribute("customerTypeList", customerTypeList);
            return "customer/updateCustomer";
        }
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg1", "Update successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam Integer id) {
        customerService.delete(id);
        return "redirect:/customer";
    }
    @GetMapping("/detailCustomer")
    public String detailCustomer(@RequestParam Integer id) {
        customerService.findById(id);
        return "redirect:/customer";
    }

    @ExceptionHandler(value = Exception.class)
    public String error() {
        return "error";
    }
}
