package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

public interface RoleDao {

    List<Role> getAllRolles();

    Role getRoleById(Long id);

    void saveRole(Role role);

}
