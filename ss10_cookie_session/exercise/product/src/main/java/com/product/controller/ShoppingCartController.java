package com.product.controller;

import com.product.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ShoppingCartController {

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shoppingCart")
    public String showCart(@SessionAttribute("cartService") Cart cart, Model model
    ) {
        model.addAttribute("cart", cart);
        return "/cart";
    }
}
