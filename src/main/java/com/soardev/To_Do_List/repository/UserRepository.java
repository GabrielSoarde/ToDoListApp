package com.soardev.To_Do_List.repository;

import com.soardev.To_Do_List.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    default Optional<User> findByUsername(String username) {
        return findByEmail(username);
    }
}
