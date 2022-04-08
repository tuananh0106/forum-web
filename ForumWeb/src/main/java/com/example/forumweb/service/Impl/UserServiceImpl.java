package com.example.forumweb.service.Impl;

import com.example.forumweb.dto.UserResgistrationDto;
import com.example.forumweb.entity.User;
import com.example.forumweb.reponsitory.UserReponsitory;
import com.example.forumweb.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserReponsitory userReponsitory;
    @Override
    public void save(UserResgistrationDto resgistrationDto) {
        User user=new User(resgistrationDto.getEmail(),
                resgistrationDto.getUserDisplayName(),
                ".",
                0,
                0,
                resgistrationDto.getPassword(),
                "8/4/2022",
                0
                );
        System.out.println(user);
        userReponsitory.save(user);
    }
}
