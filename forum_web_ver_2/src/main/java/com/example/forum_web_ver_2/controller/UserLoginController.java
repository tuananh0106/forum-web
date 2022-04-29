package com.example.forum_web_ver_2.controller;

import com.example.forum_web_ver_2.dto.UserDto;
import com.example.forum_web_ver_2.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.parser.Cookie;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
@SessionAttributes("user")
public class UserLoginController {
    private UserService userService;
    @ModelAttribute("user")
    public UserDto userDto(){
        return new UserDto();
    }
    @GetMapping("/login")
    public String showLoginForm(){
        return "/login";
    }
    @PostMapping("/login")
    public String Login(@ModelAttribute("user") UserDto userDto, Model model){
        if(userService.checkUserbyEmail(userDto.getEmail())==false){
            return "redirect:/login?emailwrong";
        }
        if(userService.checkPasswordUser(userDto.getEmail(),userDto.getPassword())){
            return "redirect:/home?success";
        }
        return "redirect:/login?passwordwrong";
    }
}
