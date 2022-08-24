package com.product.repository;

import com.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends JpaRepository {

    @Query(value = " select * from product_spring where name like :name  ", nativeQuery = true)
    Page<Product> findAllByName(Pageable pageable, @Param("name") String name);
}
