package com.product.repository.impl;

import com.product.model.Product;
import com.product.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static Map<String, Product> productMap = new HashMap();

    static {
        productMap.put("1", new Product("1", "Kẹo kéo", "234", "dai dai", "Hải hà"));
        productMap.put("2", new Product("2", "Kẹo dẻo", "634", "mềm dai", "Hải long"));
        productMap.put("3", new Product("3", "Kẹo cay", "544", "cay cay", "Trần Quỳnh"));
        productMap.put("4", new Product("4", "Kẹo cưc cay", "500", "cay cay", "Cung Cung"));
        productMap.put("5", new Product("5", "Bánh cay", "884", "mềm mềm", "Hải hoa"));
        productMap.put("6", new Product("6", "Bánh cú", "294", "cú dai", "Hải hùng"));
        productMap.put("7", new Product("7", "Bánh kéo", "2304", "cực dai", "Hoà hà"));
        productMap.put("8", new Product("8", "Bánh ít", "984", "ít dai", "Ít quá"));
    }

    @Override
    public List<Product> findAllProduct(String name) {
        List<Product> productList = new ArrayList<>();
        for (Product product : productMap.values()) {
            if (product.getName().contains(name)) {
                productList.add(product);
            }
        }
        return productList;
    }

    @Override
    public void saveProduct(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Object findById(String id) {
        return productMap.get(id);
    }

    @Override
    public void update(String id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public Object delete(String id) {
        return productMap.remove(id);
    }


}