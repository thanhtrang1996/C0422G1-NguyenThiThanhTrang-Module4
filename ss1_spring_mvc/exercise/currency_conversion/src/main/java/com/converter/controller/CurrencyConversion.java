package com.converter.controller;

import com.converter.service.IConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConversion {
    @Autowired
    private IConversionService conversionService;

    @GetMapping("/")
    public String conversion() {
        return "/home";
    }

    @PostMapping("/add")
    public String conversionUSD(@RequestParam double usd, Model model) {
        double result = conversionService.convert(usd);
        model.addAttribute("result", result);
        return "home";
    }
}

