package com.furama.service;

import com.furama.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {
    Page<Facility> findByName(Pageable pageable, String keyWork);

    void save(Facility facility);

    Facility findById(Integer id);

    void delete(Integer id);
}
