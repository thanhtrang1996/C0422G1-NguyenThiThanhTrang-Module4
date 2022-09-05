package com.phone.service.impl;

import com.phone.model.Smartphone;
import com.phone.repository.ISmartphoneRepository;
import com.phone.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SmartphoneService implements ISmartphoneService {
    @Autowired
    private ISmartphoneRepository smartphoneRepository;

    @Override
    public Page<Smartphone> findAll(Pageable pageable, String keyName) {
        return smartphoneRepository.findAllByNameContaining(keyName,pageable);
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
      return  smartphoneRepository.save(smartphone);
    }

    @Override
    public Smartphone findById(Integer id) {
        return smartphoneRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        smartphoneRepository.deleteById(id);
    }
}
