package com.example.forum_web_ver_2.reponsitory;

import com.example.forum_web_ver_2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
@EnableJpaRepositories
public interface UserReponsitory extends JpaRepository<User,Integer> {
    User getUserByEmail(String email);
    User findUserByEmail(String email);
}
