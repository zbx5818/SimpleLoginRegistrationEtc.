package com.mercury.project.auth.controller;

import com.mercury.project.auth.model.User;
import com.mercury.project.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(User user) {
        User userExist = userService.findByUsername(user.getUsername());
        if (userExist != null) {
            if (userExist.getPassword().equals(user.getPassword())) {//encryption need
                //session here
                return "login permitted";
            } else {
                return "wrong username or password";
            }
        } else {
            return "wrong username or password";
        }
    }
}
