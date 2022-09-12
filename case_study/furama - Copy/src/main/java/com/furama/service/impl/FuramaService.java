package com.furama.service.impl;

import com.furama.repository.IFuramaRepository;
import com.furama.service.IFuramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuramaService implements IFuramaService {
    @Autowired
    private IFuramaRepository furamaRepository;
}
