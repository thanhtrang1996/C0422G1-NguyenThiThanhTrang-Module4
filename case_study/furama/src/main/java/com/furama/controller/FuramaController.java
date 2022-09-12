package com.furama.controller;

import com.furama.service.IFuramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FuramaController {
    @Autowired
    private IFuramaService furamaService;

    @GetMapping("/")
    public String goHome() {
        return "home";
    }
}
