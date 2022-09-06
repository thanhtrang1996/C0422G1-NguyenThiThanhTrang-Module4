package com.blog.service;


import com.blog.entity.Province;
import com.blog.exception.ResourceNotFoundException;

import java.util.List;

public interface ProvinceService {
    List<Province> findAll();

    Province findById(Long id) throws ResourceNotFoundException;

    void save(Province province);

    void remove(Long id);
}