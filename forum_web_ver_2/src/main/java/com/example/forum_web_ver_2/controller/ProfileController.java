package com.example.forum_web_ver_2.controller;

import com.example.forum_web_ver_2.dto.ProfileDto;
import com.example.forum_web_ver_2.dto.UserDto;
import com.example.forum_web_ver_2.entity.Profile;
import com.example.forum_web_ver_2.entity.User;
import com.example.forum_web_ver_2.service.ProfileService;
import com.example.forum_web_ver_2.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@SessionAttributes("userdto")
public class ProfileController {
    private UserService userService;
    private ProfileService profileService;
    @ModelAttribute("userdto")
    public UserDto userDto(){
        return new UserDto();
    }
    @ModelAttribute("profile")
    public ProfileDto profileDto(){
        return new ProfileDto();
    }
    @GetMapping("/profile")
    public String showprofile(@ModelAttribute("userdto")UserDto userDto, Model model){
        User user = userService.getUserbyEmail(userDto.getEmail());
        if(user ==null){
            return "redirect:/login";
        }
        model.addAttribute("user",user);
        Profile profile = profileService.findProfileByUser(user);
        model.addAttribute("profile",profile);
        return "/profile";
    }
    @PostMapping("/profile")
    public String getprofile(@SessionAttribute("userdto")UserDto userDto, Model model,
                             @PathVariable("firstName") String firstName){
        User user = userService.getUserbyEmail(userDto.getEmail());
        ProfileDto profileDto=new ProfileDto();
        profileService.save(profileDto,user);
        return "/profile";
    }
}
