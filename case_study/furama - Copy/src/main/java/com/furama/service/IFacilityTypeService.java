package com.furama.service;
import com.furama.model.FacilityType;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IFacilityTypeService {
    List<FacilityType> findAll();
}
