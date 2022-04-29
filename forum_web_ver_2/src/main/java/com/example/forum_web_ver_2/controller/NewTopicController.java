package com.example.forum_web_ver_2.controller;

import com.example.forum_web_ver_2.dto.TopicDto;
import com.example.forum_web_ver_2.dto.UserDto;
import com.example.forum_web_ver_2.entity.User;
import com.example.forum_web_ver_2.reponsitory.UserReponsitory;
import com.example.forum_web_ver_2.service.TopicService;
import com.example.forum_web_ver_2.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class NewTopicController {
    private TopicService topicService;
    private UserService userService;
    private UserReponsitory userReponsitory;
    @ModelAttribute("topic")
    public TopicDto topicDto(){
        return new TopicDto();
    }
    @ModelAttribute("user")
    public UserDto userDto(){
        return new UserDto();
    }
    @GetMapping("/newtopic")
    public String showNewTopic(){
        return "/newtopic";
    }
    @PostMapping("/newtopic")
    public String newTopic(@SessionAttribute("user") UserDto userDto,@ModelAttribute("topic") TopicDto topicDto,Model model){
        User user = userReponsitory.getUserByEmail(userDto.getEmail());
        topicService.save(topicDto,user);
        return "redirect:/home";
    }
}
