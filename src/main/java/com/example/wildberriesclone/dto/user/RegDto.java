package com.example.wildberriesclone.dto.user;

import com.example.wildberriesclone.entity.account.user.Genre;
import com.example.wildberriesclone.entity.account.user.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor @AllArgsConstructor
public class RegDto {
    private String username;
    private String password;
    private Genre genre;
    private String email;
    private Set<Role> roles;
}
