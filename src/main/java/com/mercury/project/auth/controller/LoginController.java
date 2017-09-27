package com.mercury.project.auth.controller;

import com.mercury.project.auth.model.User;
import com.mercury.project.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
/**
 * The class is no longer used. It's implemented in Spring Security
 */
public class LoginController {
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public LoginController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/login")
    public String login(User user) {
        User userExist = userService.findByUsername(user.getUsername());
        if (userExist != null) {
            if (userExist.getPassword().equals(bCryptPasswordEncoder.encode(user.getPassword()))) {//encryption need
                return "login permitted";
            } else {
                return "wrong username or password";
            }
        } else {
            return "wrong username or password";
        }
    }


}
