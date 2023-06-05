package com.example.login.Controller;

import com.example.login.Entity.Data.UserData;
import com.example.login.Repository.UserRepository;
import com.example.login.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    UserService userService;
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("UserData", new UserData());
        return "account/register" ;
    }
    @PostMapping("/register")
    public String UserRegistration(final @Valid UserData userData, final BindingResult bindingResult, final  Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("RegistrationForm",userData);
            return "account/register";
        }try{
                userService.Register(userData);
        }catch (Exception e){
            bindingResult.rejectValue("email","An account already exists");
            model.addAttribute("RegistrationForm",userData);
            return "account/register";
        }
        return "/starter";
    }
}
