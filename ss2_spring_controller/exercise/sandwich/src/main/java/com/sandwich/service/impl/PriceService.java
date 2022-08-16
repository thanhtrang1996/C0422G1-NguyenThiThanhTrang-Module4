package com.sandwich.service.impl;

import com.sandwich.repository.IPriceRepository;
import com.sandwich.service.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService implements IPriceService {
    @Autowired
    private IPriceRepository priceRepository;

    @Override
    public List<String> priceAll() {
        return priceRepository.priceAll();
    }


}
