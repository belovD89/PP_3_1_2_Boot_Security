package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    void deleteUser(long id);

    User getUserId(long id);

    void addUser(List<Role> role, String name, String lastName, String password, String email);

    User findUserByName(String userName);

    void update(Long id, User user);
}
