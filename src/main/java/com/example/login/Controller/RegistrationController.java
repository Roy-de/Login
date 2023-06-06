package com.example.login.Controller;

import com.example.login.Entity.Data.UserData;
import com.example.login.Service.UserService;
import lombok.SneakyThrows;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    UserService userService;

    public RegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }
    @ModelAttribute("user")
    public UserData userData(){
        return new UserData();
    }
    @GetMapping
    public String showRegistrationForm(){
        return "registration";
    }
    @SneakyThrows
    @PostMapping
    public String registerUser(@ModelAttribute("user") UserData userData) {
        userService.Register(userData);
        return "redirect:/registration?success";
    }
}
