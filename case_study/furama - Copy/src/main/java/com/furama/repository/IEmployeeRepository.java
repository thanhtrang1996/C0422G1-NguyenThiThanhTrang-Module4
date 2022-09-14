package com.furama.repository;

import com.furama.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "select * from employee where `name` like  :name", nativeQuery = true,
    countQuery = "select  count(*) from (select * from employee where `name` like  :name) countPage")
    Page<Employee> findAllByName(Pageable pageable, String name);
}
