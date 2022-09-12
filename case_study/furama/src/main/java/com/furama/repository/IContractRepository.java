package com.furama.repository;

import com.furama.dto.ContractPage;
import com.furama.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract,Integer> {
    Page<Contract> findAllByDepositContaining(Pageable pageable, String keyWord);

    @Query(value = "call total()", nativeQuery = true)
    List<ContractPage> totalMoney();

    @Query(value = " SELECT \n" +
            "            contract.id,\n" +
            "           f.`name` as facility,\n" +
            "           customer.`name`,\n" +
            "             contract.start_date as start,\n" +
            "             contract.end_date as end,\n" +
            "             contract.deposit,\n" +
            "              SUM((IFNULL(contract_detail.quantity * attach_facility.cost,\n" +
            "                    0)) + f.cost)  as total\n" +
            "            FROM\n" +
            "               customer\n" +
            "             LEFT JOIN\n" +
            "              customer_type ON customer.id = customer_type.id\n" +
            "              LEFT JOIN\n" +
            "               contract ON contract.customer_id = customer.id\n" +
            "              LEFT JOIN\n" +
            "               facility f ON contract.facility_id = f.id\n" +
            "                LEFT JOIN\n" +
            "         contract_detail ON contract_detail.contract_id = contract.id\n" +
            "                  LEFT JOIN\n" +
            "           attach_facility ON contract_detail.attach_facility_id = attach_facility.id\n" +
            "            GROUP BY contract.id",countQuery = "select count(*) from (SELECT \n" +
            "contract.id,\n" +
            " f.`name` as facility,\n" +
            " customer.`name`,\n" +
            " contract.start_date as start,\n" +
            " contract.end_date as end,\n" +
            " contract.deposit,\n" +
            "    SUM((IFNULL(contract_detail.quantity * attach_facility.cost,\n" +
            "            0)) + f.cost)  as total\n" +
            "FROM\n" +
            "    customer\n" +
            "        LEFT JOIN\n" +
            "   customer_type ON customer.id = customer_type.id\n" +
            "        LEFT JOIN\n" +
            "    contract ON contract.customer_id = customer.id\n" +
            "        LEFT JOIN\n" +
            "    facility f ON contract.facility_id = f.id\n" +
            "        LEFT JOIN\n" +
            "    contract_detail ON contract_detail.contract_id = contract.id\n" +
            "        LEFT JOIN\n" +
            "   attach_facility ON contract_detail.attach_facility_id = attach_facility.id\n" +
            "GROUP BY contract.id) as pageCount ",nativeQuery = true)
    Page<ContractPage> money(Pageable pageable);
}
