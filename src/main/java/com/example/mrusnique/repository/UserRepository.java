package com.example.mrusnique.repository;

import com.example.mrusnique.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByClerkId(String clerkId);
    User findByUsername(String username);
    User findByEmail(String email);
}

