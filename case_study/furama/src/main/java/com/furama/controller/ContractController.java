package com.furama.controller;

import com.furama.model.*;
import com.furama.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private IAttachFacilityService attachFacilityService;
    @Autowired
    private IContractDetailService contractDetailService;
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private ICustomerService customerService;

    @ModelAttribute("facilityList")
    public List<Facility> getFacility() {
        return facilityService.findAll();
    }

    ;

    @ModelAttribute("customerList")
    public List<Customer> getCustomer() {
        return customerService.findAll();
    }

    ;

    @ModelAttribute("attachFacilityList")
    public List<AttachFacility> getAttachFacility() {

        return attachFacilityService.findAll();
    }

    @ModelAttribute("contractDetailList")
    public List<ContractDetail> getContractDetail() {

        return contractDetailService.findAll();
    }

    @GetMapping("/contract")
    public String goListContract(Model model,
                                 @PageableDefault(size = 5) Pageable pageable
    ) {
        model.addAttribute("contractPage", contractService.totalMoney(pageable));
        model.addAttribute("size", pageable.getPageSize());
        model.addAttribute("contract", new Contract());
        return "contract/listContract";
    }

    @GetMapping("/createContract")
    public String showCreate(Model model) {
        model.addAttribute("contract", new Contract());
        return "contract/listContract";
    }

    @PostMapping("/createContract")
    public String createContract(Contract contract) {
        contractService.save(contract);
        return "redirect:/contract";
    }
}