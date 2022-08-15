package com.dictionary.controller;

import com.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping("/")
    public String dictionary() {
        return "dictionary";
    }
    @GetMapping("/list")
    public String dictionary(@RequestParam String name, Model model) {
        String result = dictionaryService.listDictionary(name);
        model.addAttribute("result", result);
        return "dictionary";
    }
}
