package com.example.forum_web_ver_2.service;

import com.example.forum_web_ver_2.dto.CommentDto;
import com.example.forum_web_ver_2.entity.Topic;
import com.example.forum_web_ver_2.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    void save(CommentDto commentDto, User user, Topic topic);
    int countComment(Topic topic);
}
