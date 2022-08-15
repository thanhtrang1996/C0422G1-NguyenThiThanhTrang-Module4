package com.converter.service.impl;

import com.converter.service.IConversionService;
import org.springframework.stereotype.Service;

@Service
public class ConversionService implements IConversionService {

    @Override
    public double convert(double usd) {
        return 23000 * usd;
    }
}
