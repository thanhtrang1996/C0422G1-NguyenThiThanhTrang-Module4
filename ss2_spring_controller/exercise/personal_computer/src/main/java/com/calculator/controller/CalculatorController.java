package com.calculator.controller;

import com.calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService iCalculatorServiceService;

    @GetMapping("/")
    public String showFormCalculator() {
        return "calculator";
    }

    @PostMapping("calculate")
    public String computer(@RequestParam double number1,
                           @RequestParam double number2,
                           @RequestParam String choose,
                           Model model) {
        String result = iCalculatorServiceService.calculator(number1, number2, choose);
        model.addAttribute("result", result);
        return "calculator";
    }
}
