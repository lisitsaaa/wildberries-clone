package com.example.wildberriesclone.entity.account.user;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, MANAGER, SELLER, USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
