package com.furama.service.impl;

import com.furama.model.AttachFacility;
import com.furama.repository.IAttachFacilityRepository;
import com.furama.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }
}
