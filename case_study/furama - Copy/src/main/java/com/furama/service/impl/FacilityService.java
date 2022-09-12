package com.furama.service.impl;

import com.furama.model.Facility;
import com.furama.repository.IFacilityRepository;
import com.furama.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> findByName(Pageable pageable, String keyWork) {
        return facilityRepository.findByNameContaining(pageable,keyWork);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        facilityRepository.delete(findById(id));
    }

    @Override
    public Facility findById(Integer id) {
      return   facilityRepository.findById(id).orElse(null);
    }
}
