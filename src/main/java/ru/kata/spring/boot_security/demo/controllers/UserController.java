package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;


@Controller
public class UserController {

//    @Autowired
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    //Отображение пользователей
    @GetMapping("/")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "main-page";
    }

    //Добавление пользователя
    @GetMapping("/add-user")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("newUser", user);
        return "user-info";
    }

    //Добавление пользователя
    @PostMapping()
    public String createUser(@ModelAttribute("newUser") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    //Удаление пользователя
    @RequestMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    //Обновление данных пользователя
    @RequestMapping("/update-info/{id}")
    public String updateUser(Model model, @PathVariable("id") long id) {
        User currentUser = userService.getUser(id);
        model.addAttribute("newUser", currentUser);
        return "user-info";
    }
}
