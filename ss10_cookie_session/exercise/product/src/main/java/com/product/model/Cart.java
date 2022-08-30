package com.product.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();
    private Integer productQuantity;
    private float countTotalPayment;

    public float getCountTotalPayment() {
        return countTotalPayment;
    }

    public void setCountTotalPayment(float countTotalPayment) {
        this.countTotalPayment = countTotalPayment;
    }

    public Cart() {
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }


    public Integer countItemQuantity() {
        return products.size();
    }


}
