package ru.kata.spring.boot_security.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

@SpringBootApplication
public class SpringBootSecurityDemoApplication {
    final RoleService roleService;
    final UserService userService;

    public SpringBootSecurityDemoApplication(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

	public static void main(String[] args) {

        SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner CommandLineRunnerBean() {
        return (args) -> {
            Role adminRole = new Role("ROLE_ADMIN");

            roleService.addRole(adminRole);

            Role userRole = new Role("ROLE_USER");

            roleService.addRole(userRole);

            User user = new User();
            user.setName("user");
            user.setSurname("surName1");
            user.setEmail("user1@mail.ru");
            user.setPassword("password1User");
            user.setRole(userRole);
            userService.saveUser(user);

            User user1 = new User();
            user1.setName("admin");
            user1.setSurname("adminSurname");
            user1.setEmail("admin@mail.ru");
            user1.setPassword("passwordAdmin");
            user1.setRole(adminRole);
            userService.saveUser(user1);
        };
    }

}
