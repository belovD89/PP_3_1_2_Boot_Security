package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();
    public void save(User user);
    public void deleteUser(long id);
    public User getUser(long id);
}
