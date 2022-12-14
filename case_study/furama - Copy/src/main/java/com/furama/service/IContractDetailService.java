package com.furama.service;

import com.furama.model.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);

    void updateQuantity(Integer quantity, Integer contractId, Integer attachFacilityId);
}
