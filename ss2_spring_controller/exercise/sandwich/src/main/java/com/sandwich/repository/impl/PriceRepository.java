package com.sandwich.repository.impl;

import com.sandwich.repository.IPriceRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PriceRepository implements IPriceRepository {
    private static List<String> priceList = new ArrayList<>();

    static {
        priceList.add("Lettuce");
        priceList.add("Tomato");
        priceList.add("Mustard");
        priceList.add("Sprouts");
    }

    @Override
    public List<String> priceAll() {
        return priceList;
    }
}
