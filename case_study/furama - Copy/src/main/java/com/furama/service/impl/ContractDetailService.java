package com.furama.service.impl;

import com.furama.model.ContractDetail;
import com.furama.repository.IContractDetailRepository;
import com.furama.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return this.contractDetailRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        this.contractDetailRepository.save(contractDetail);
    }

    @Override
    public void updateQuantity(Integer quantity, Integer contractId, Integer attachFacilityId) {
        this.contractDetailRepository.updateQuantity(quantity, contractId, attachFacilityId);
    }
}
