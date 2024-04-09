package ru.kata.spring.boot_security.demo.service;

import antlr.collections.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.model.Role;

@Service
public class RoleServiceImp implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> getAllRolles() {
        return roleDao.getAllRolles();
    }

    @Override
    public void addRole(ru.kata.spring.boot_security.demo.model.Role role) {

    }

    @Override
    @Transactional
    public void addRole(Role role) {
        roleDao.saveRole(role);
    }
}
