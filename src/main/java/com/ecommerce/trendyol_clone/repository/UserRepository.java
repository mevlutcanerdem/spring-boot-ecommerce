package com.ecommerce.trendyol_clone.repository;

import com.ecommerce.trendyol_clone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    // SELECT * FROM users WHERE username = ?
    Optional<User> findByUsername(String username);
}
