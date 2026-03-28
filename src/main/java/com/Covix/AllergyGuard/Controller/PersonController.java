package com.Covix.AllergyGuard.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.Covix.AllergyGuard.Entity.Person;
import com.Covix.AllergyGuard.Service.PersonService;

@Controller
public class PersonController {

    @Autowired
    private PersonService service;

    // Default mapping: / → redirect /register
    @GetMapping("/")
    public String home() {
        return "redirect:/register"; // অথবা "/login"
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("person", new Person());
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute Person person) {
        service.register(person);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login-process")
    public String loginProcess(@RequestParam String email,
                               @RequestParam String password,
                               Model model) {

        Person p = service.login(email, password);

        if (p != null) {
            model.addAttribute("name", p.getName());
            return "dashboard";
        }

        model.addAttribute("error", "Invalid email or password");
        return "login";
    }
}