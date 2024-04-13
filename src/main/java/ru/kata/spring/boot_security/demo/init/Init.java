package ru.kata.spring.boot_security.demo.init;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Collections;


public class Init {
    private final UserService userService;
    private final RoleService roleService;

    public Init(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void initUsers() {
        Role adminRole = new Role("ROLE_ADMIN");

        roleService.addRole(adminRole);

        Role userRole = new Role("ROLE_USER");

        roleService.addRole(userRole);

        User user = new User();
        user.setName("user");
        user.setEmail("user@mail.ru");
        user.setPassword("passwordUser");
        user.setRoles(Collections.singleton(userRole));
        userService.saveUser(user);

        User user1 = new User();
        user1.setName("admin");
        user1.setEmail("admin@mail.ru");
        user1.setPassword("passwordAdmin");
        user1.setRoles(Collections.singleton(adminRole));
        userService.saveUser(user1);
    }
}
