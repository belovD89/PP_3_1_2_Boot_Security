package ru.kata.spring.boot_security.demo.repository;

import antlr.collections.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLastName(String last_name);
}
