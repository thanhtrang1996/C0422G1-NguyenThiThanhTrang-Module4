package com.product.controller;

import com.product.model.Cart;
import com.product.model.Product;
import com.product.service.IProductService;
import com.product.service.impl.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@SessionAttributes("cartService")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private CartService cartService;

    @ModelAttribute("cartService")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public String showShop(Model model) {
        model.addAttribute("products", productService.findAll());
        return "shop";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Integer id, @SessionAttribute("cartService") Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "error";
        }
        if (action.equals("show")) {
            cartService.addProduct(productOptional.get(), cart);
            return "redirect:/shoppingCart";
        }
        if (action.equals("preview")) {
            cartService.preQuantity(productOptional.get(), cart);
            return "redirect:/shoppingCart";
        }
        cartService.addProduct(productOptional.get(), cart);
        return "redirect:/shop";
    }
}
