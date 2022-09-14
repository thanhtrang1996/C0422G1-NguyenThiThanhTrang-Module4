package com.furama.service;

import com.furama.dto.ContractPage;
import com.furama.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IContractService {

    Page<Contract> findAllByDeposit(Pageable pageable, String keyWork);


    List<ContractPage> total();

    Page<ContractPage> totalMoney(Pageable pageable);

    void save(Contract contract);

    Contract findById(Integer id);
}
