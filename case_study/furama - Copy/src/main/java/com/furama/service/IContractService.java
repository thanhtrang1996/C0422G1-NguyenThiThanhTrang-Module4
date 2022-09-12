package com.furama.service;

import com.furama.dto.ContractPage;
import com.furama.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface IContractService {
    Page<Contract> getAllContract(Pageable pageable, String startDate, String endDate);

    Contract findByAttachFacilityIdAndContractId(Integer contractId, Integer attachFacilityId);

    Contract save(Contract contract);
}
