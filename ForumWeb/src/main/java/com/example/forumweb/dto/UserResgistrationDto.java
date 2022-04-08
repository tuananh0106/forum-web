package com.example.forumweb.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResgistrationDto {
    private String Email;
    private String UserDisplayName;
    private String Password;
}
