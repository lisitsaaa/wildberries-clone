package com.example.wildberriesclone.service;

import com.example.wildberriesclone.entity.account.user.User;
import com.example.wildberriesclone.exception.ExistsException;
import com.example.wildberriesclone.repository.UserRepository;
import com.example.wildberriesclone.service.util.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    @Value("${NOT_FOUND}") private String not_found_message;
    @Value("${EXISTED}") private String existed_message;

    private final UserRepository userRepository;

    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public User save(User user, BindingResult bindingResult){
        Validator.checkBindingResult(bindingResult);

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new ExistsException(String.format(existed_message, user.getUsername()));
        }
        user.setPassword(passwordEncoder().encode(user.getPassword()));

        return userRepository.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
