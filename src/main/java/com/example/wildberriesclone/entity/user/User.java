package com.example.wildberriesclone.entity.user;

import com.example.wildberriesclone.entity.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "users")
@Setter @Getter
@Builder @AllArgsConstructor @NoArgsConstructor
public class User extends AbstractEntity{
    private String username;
    private String password;
    private String email;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
}
