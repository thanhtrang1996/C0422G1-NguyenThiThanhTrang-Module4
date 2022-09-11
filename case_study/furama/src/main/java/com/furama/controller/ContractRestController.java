package com.furama.controller;

import com.furama.dto.ContractPage;
import com.furama.model.Contract;
import com.furama.service.IAttachFacilityService;
import com.furama.service.IContractDetailService;
import com.furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/contractRest")
@RestController
public class ContractRestController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private IAttachFacilityService attachFacilityService;
    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("/list")
    public ResponseEntity<Page<ContractPage>> goPage(@PageableDefault(5) Pageable pageable) {
        Page<ContractPage> contractPage = contractService.totalMoney(pageable);

        if (!contractPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractPage, HttpStatus.OK);
    }

}
