package com.calculator.service.impl;

import com.calculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String calculator(double number1, double number2, String choose) {
        String result = "";
        switch (choose) {
            case "addition":
                result = String.valueOf(number1 + number2);
                break;
            case "subtraction":
                result = String.valueOf(number1 - number2);
                break;
            case "multiplication":
                result = String.valueOf(number1 * number2);
                break;
            case "division":
                if (number2 == 0) {
                    result = "Can't division for 0";
                } else {
                    result = String.valueOf(number1 / number2);
                }
                break;
        }
        return result;
    }
}
