package com.example.forumweb.controller;

import com.example.forumweb.dto.UserResgistrationDto;
import com.example.forumweb.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class UserRegistrationController {
    private UserService userService;
    @ModelAttribute("user")
    public UserResgistrationDto userResgistrationDto(){
        return new UserResgistrationDto();
    }
    @GetMapping("/registration")
    public String showRegistrationForm(){
        return "/registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") UserResgistrationDto userResgistrationDto){
        userService.save(userResgistrationDto);
        return "redirect:/registration?success";
    }
}
