package com.furama.repository;

import com.furama.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    @Modifying
    @Transactional
    @Query(value = " UPDATE contract_detail " +
            " SET quantity = (ifnull(quantity,0) + :quantity) " +
            " WHERE contract_id = :contractId and attach_facility_id = :attachFacilityId ",
            nativeQuery = true)
    void updateQuantity(@Param("quantity") Integer quantity,
                        @Param("contractId") Integer contractId,
                        @Param("attachFacilityId") Integer attachFacilityId);
}
