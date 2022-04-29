package com.example.forum_web_ver_2.reponsitory;

import com.example.forum_web_ver_2.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CommentReponsitory  extends JpaRepository<Comment,Integer> {
    List<Comment> getAllByTopic_Id(Integer topicId);
    Integer countCommentByTopic_Id(Integer topicId);
}
