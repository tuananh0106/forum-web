package com.example.forumweb.service;

import com.example.forumweb.dto.UserResgistrationDto;
import com.example.forumweb.entity.User;

public interface UserService {
    void save(UserResgistrationDto resgistrationDto);
}
