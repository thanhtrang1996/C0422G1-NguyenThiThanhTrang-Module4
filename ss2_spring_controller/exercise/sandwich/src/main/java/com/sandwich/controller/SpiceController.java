package com.sandwich.controller;

import com.sandwich.service.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SpiceController {
    @Autowired
    private IPriceService priceService;

    @GetMapping("/")
    public String sandwich(Model model) {
        List<String> priceList = priceService.priceAll();
        model.addAttribute("price", priceList);
        return "list";
    }

    @GetMapping("/list")
    public String sandwichPrice(@RequestParam List<String> condiments, Model model) {
        List<String> result = condiments;
        model.addAttribute("result", result);
        return "list";
    }
}
