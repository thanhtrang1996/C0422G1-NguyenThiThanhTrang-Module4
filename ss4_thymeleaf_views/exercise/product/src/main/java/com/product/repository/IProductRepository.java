package com.product.repository;

import com.product.model.Product;

import java.util.List;
import java.util.Map;

public interface IProductRepository {
    List<Product> findAllProduct();

    void saveProduct(Product product);

    Object findById(String id);

    void update(String id, Product product);

    Object delete(String id);

    List<Product> search(String name);
}
