package com.mercury.project.auth.repository;

import com.mercury.project.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByFirstName(String firstName);
}
