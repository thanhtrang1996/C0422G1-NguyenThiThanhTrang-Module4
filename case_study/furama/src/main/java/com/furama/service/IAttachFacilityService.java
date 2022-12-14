package com.furama.service;

import com.furama.model.AttachFacility;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAll();

    List<AttachFacility> getAttachFacilityByID(Integer id);

    AttachFacility findById(Integer id);
}
