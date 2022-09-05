package com.phone.service;


import com.phone.model.Smartphone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISmartphoneService {

    Page<Smartphone> findAll(Pageable pageable, String keyName);

    Smartphone save(Smartphone smartphone);

    Smartphone findById(Integer id);

    void delete(Integer id);
}
