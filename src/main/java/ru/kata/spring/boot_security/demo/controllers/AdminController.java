package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.context.annotation.Role;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String getAllUsers(@AuthenticationPrincipal User user, Role role, Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.getAllRolles());
        model.addAttribute("roles", role);
        return "admin/main-page";
    }


//    //    @Autowired
//    private UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//
//    //Отображение пользователей
//    @GetMapping("/")
//    public String getAllUsers(Model model) {
//        model.addAttribute("users", userService.getAllUsers());
//        return "admin/main-page";
//    }
//
//    //Добавление пользователя
//    @GetMapping("/add-user")
//    public String addUser(Model model) {
//        ru.kata.spring.boot_security.demo.model.User user = new ru.kata.spring.boot_security.demo.model.User();
//        model.addAttribute("newUser", user);
//        return "user-info";
//    }
//
//    //Добавление пользователя
//    @PostMapping()
//    public String createUser(@ModelAttribute("newUser") ru.kata.spring.boot_security.demo.model.User user) {
//        userService.saveUser(user);
//        return "redirect:/";
//    }
//
//    //Удаление пользователя
//    @RequestMapping("/user-delete/{id}")
//    public String deleteUser(@PathVariable("id") long id) {
//        userService.deleteUser(id);
//        return "redirect:/";
//    }
//
//    //Обновление данных пользователя
//    @RequestMapping("/update-info/{id}")
//    public String updateUser(Model model, @PathVariable("id") long id) {
//        ru.kata.spring.boot_security.demo.model.User currentUser = userService.getUser(id);
//        model.addAttribute("newUser", currentUser);
//        return "user-info";
//    }

}
