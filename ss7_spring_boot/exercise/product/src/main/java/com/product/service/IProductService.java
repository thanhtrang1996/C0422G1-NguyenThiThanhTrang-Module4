package com.product.service;

import com.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAllByName(Pageable pageable, String keyName);

    void save(Product product);

    Object findById(Integer id);

    void delete(Integer id);
}
