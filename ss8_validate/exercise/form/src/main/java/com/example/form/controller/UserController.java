package com.example.form.controller;

import com.example.form.dto.UserDto;
import com.example.form.model.User;
import com.example.form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/display")
    public String display(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "display";
    }

    @PostMapping("/display")
    public String displayForm(@ModelAttribute("user") @Valid UserDto userDto,
                              BindingResult bindingResult,
                              Model model) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "display";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        model.addAttribute("userDto", userDto);
        this.userService.save(user);
        model.addAttribute("msg", "Register successfully!");
        return "list";
    }

}
