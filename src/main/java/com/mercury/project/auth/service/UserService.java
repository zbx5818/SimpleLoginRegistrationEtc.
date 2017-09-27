package com.mercury.project.auth.service;

import com.mercury.project.auth.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    User findByFirstName(String firstName);

    List<User> findAll();
}
