package ru.kata.spring.boot_security.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootSecurityDemoApplication {
	@GetMapping("/")
	public String homePage() {
		return "home";
	}

}
