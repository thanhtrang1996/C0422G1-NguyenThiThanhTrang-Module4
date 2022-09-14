package com.furama.repository;

import com.furama.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IContractRepository extends JpaRepository<Contract,Integer> {

    @Query(value = " SELECT * FROM contract where end_date between start_date and end_date ",
            nativeQuery = true, countQuery = " select count(*) from( SELECT * FROM contract where end_date between start_date and end_date ) as page")
    Page<Contract> getAllContract(Pageable pageable, @Param("startDateValue") String startDateValue, @Param("endDateValue") String endDateValue);

    @Query(value = " select * from contract join  contract_detail ON contract_detail.contract_id = contract.id\n" +
            "            join   attach_facility ON contract_detail.attach_facility_id = attach_facility.id\n" +
            "            where contract_id = :contractId and attach_facility_id = :attachFacilityId ", nativeQuery = true)
    Contract findByAttachFacilityIdAndContractId(@Param("contractId") Integer contractId,@Param("attachFacilityId") Integer attachFacilityId);
}
