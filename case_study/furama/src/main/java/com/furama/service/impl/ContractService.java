package com.furama.service.impl;

import com.furama.dto.ContractPage;
import com.furama.model.Contract;
import com.furama.repository.IContractRepository;
import com.furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Page<Contract> findAllByDeposit(Pageable pageable, String keyWork) {
        return contractRepository.findAllByDepositContaining(pageable, keyWork);
    }

    @Override
    public List<ContractPage> total() {
        return contractRepository.totalMoney();
    }

    @Override
    public Page<ContractPage> totalMoney(Pageable pageable) {
        return contractRepository.money(pageable);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

}
