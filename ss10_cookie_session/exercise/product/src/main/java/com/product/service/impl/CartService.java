package com.product.service.impl;

import com.product.model.Cart;
import com.product.model.Product;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartService {

    private boolean checkItemInCart(Product product, Cart cart1) {
        for (Map.Entry<Product, Integer> entry : cart1.getProducts().entrySet()) {
            if (entry.getKey().equals(product)) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product, Cart cart1) {
        for (Map.Entry<Product, Integer> entry : cart1.getProducts().entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product, Cart cart1) {
        if (!checkItemInCart(product, cart1)) {
            cart1.getProducts().put(product, 1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product, cart1);
            Integer newQuantity = itemEntry.getValue() + 1;
            cart1.getProducts().put(itemEntry.getKey(), newQuantity);
        }
    }

    public void preQuantity(Product product, Cart cart1) {
        if (checkItemInCart(product, cart1)) {
            if (cart1.getProducts().get(product) > 1) {
                Map.Entry<Product, Integer> itemEntry = selectItemInCart(product, cart1);
                cart1.getProducts().put(itemEntry.getKey(), itemEntry.getValue() - 1);
            } else {
                cart1.getProducts().remove(product);
            }
        }
    }
}