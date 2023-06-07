package com.example.login.Controller;

import com.example.login.Entity.Data.UserData;
import com.example.login.Service.UserService;
import lombok.SneakyThrows;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import static org.springframework.security.authorization.AuthorityReactiveAuthorizationManager.hasAuthority;

@RestController
@RequestMapping("/")
@EnableReactiveMethodSecurity
@EnableMethodSecurity
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
        return "/login";
    }
    @SneakyThrows
    @PostMapping("/signup")
    public String registerUser(@ModelAttribute("user") UserData userData) {
        userService.Register(userData);
        return "redirect:/signup?success";
    }
    @GetMapping("/login")
    public String showLoginForm(@ModelAttribute("user") UserData userData){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "login";
        }
        return "redirect:/login?success";
    }
    @GetMapping("/home")
    public String homepage(){
        return "Welcome home m**fucker";
    }
    @GetMapping("/Dashboard")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String dashboard(){
        return "dashboard";
    }
}
