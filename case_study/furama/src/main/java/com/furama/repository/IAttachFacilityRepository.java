package com.furama.repository;

import com.furama.model.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility,Integer> {
    @Query(value = " select attach_facility.* from contract\n" +
            "            join  contract_detail ON contract_detail.contract_id = contract.id\n" +
            "                   JOIN\n" +
            "           attach_facility ON contract_detail.attach_facility_id = attach_facility.id\n" +
            "           where contract.id = :id",nativeQuery = true)
    List<AttachFacility> getAttachFacilityByID(Integer id);

}
