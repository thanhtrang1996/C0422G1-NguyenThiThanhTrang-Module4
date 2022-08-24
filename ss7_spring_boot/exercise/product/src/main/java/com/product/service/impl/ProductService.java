package com.product.service.impl;

import com.product.model.Product;
import com.product.repository.IProductRepository;
import com.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
   @Autowired
   private IProductRepository productRepository;

   @Override
   public Page<Product> findAllByName(Pageable pageable, String keyName) {
      return productRepository.findAllByName(pageable,"%" + keyName + "%");
   }

   @Override
   public void save(Product product) {
      productRepository.save(product);
   }

   @Override
   public Product findById(Integer id) {
      return (Product) productRepository.findById(id).orElse(new Product());
   }

   @Override
   public void delete(Integer id) {
      productRepository.delete(findById(id));

   }
}
