package com.product.controller;

import com.product.model.Product;
import com.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/home")
    public String goList(Model model, @PageableDefault(5) Pageable pageable,
                         @RequestParam Optional<String> name) {
        for (Sort.Order order : pageable.getSort()) {
            model.addAttribute("sortValue", order.getProperty());
        }
        String keyName = name.orElse("");
        Page<Product> productPage = productService.findAllByName(pageable, keyName);
        model.addAttribute("productPage", productPage);
        model.addAttribute("name", keyName);
        return "list";
    }
    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/home";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/home";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        productService.delete(id);
        return "redirect:/home";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam Integer id) {
        productService.findById(id);
        return "redirect:/home";
    }

}