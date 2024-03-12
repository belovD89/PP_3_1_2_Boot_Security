package ru.kata.spring.boot_security.demo.controller;

import org.hibernate.mapping.Set;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.HashSet;

@Controller
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("admin")
    public ModelAndView adminPage(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin.html");
        modelAndView.addObject("allUsers", userService.findAll());
        modelAndView.addObject("allRoles", roleService.findAllRoles());
        modelAndView.addObject("currentUser", userService.findByLastName(principal.getName()));
        modelAndView.addObject("newUser", new User());
        return modelAndView;
    }

    @GetMapping("user")
    public ModelAndView userPage(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user.html");
        modelAndView.addObject("allUsers", userService.findAll());
        modelAndView.addObject("allRoles", roleService.findAllRoles());
        modelAndView.addObject("currentUser", userService.findByLastName(principal.getName()));
        return modelAndView;
    }

    @PostMapping("user-update/{id}")
    public ModelAndView updateUser(Long id, User user, @RequestParam(value = "roles", required = false) Set<Long> roleIds) {
        ModelAndView modelAndView = new ModelAndView();
        Set<Role> currentRoles = userService.findById(id).get().getRoles();
        Set<Role> roles = new HashSet<>();
        if (roleIds != null) {
            for (Long i : roleIds) {
                roles.add(roleService.findById(i).get());
                user.setRoles(roles);
            }
        } else {
            user.setRoles(currentRoles);
        }
        userService.saveUser(user);

        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }

    @PostMapping("user-delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        userService.deleteById(id);
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }

    @PostMapping("user-create")
    public ModelAndView createUser(User user) {
        ModelAndView modelAndView = new ModelAndView();
        userService.saveUser(user);
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }

}
