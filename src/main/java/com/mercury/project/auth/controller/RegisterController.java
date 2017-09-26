package com.mercury.project.auth.controller;

import com.mercury.project.auth.service.UserService;
import com.mercury.project.auth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registration(User user, BindingResult bindingResult) {
        //do validation here
        //UserValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/registration";
        }

        userService.save(user);

        //do auto login for spring security

        return "redirect:/homepage";

    }
}
