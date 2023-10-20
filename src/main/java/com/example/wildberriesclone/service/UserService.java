package com.example.wildberriesclone.service;

import com.example.wildberriesclone.entity.account.user.User;
import com.example.wildberriesclone.exception.ExistsException;
import com.example.wildberriesclone.exception.InvalidDataException;
import com.example.wildberriesclone.exception.NotFoundException;
import com.example.wildberriesclone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.util.Optional;

import static com.example.wildberriesclone.service.util.Validator.checkBindingResult;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    @Value("${NOT_FOUND}") private String not_found_message;
    @Value("${EXISTED}") private String existed_message;
    @Value("${INVALID_PASSWORD}") private String invalid_password;

    private final UserRepository userRepository;

    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public User save(User user, BindingResult bindingResult) {
        checkBindingResult(bindingResult);

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new ExistsException(String.format(existed_message, user.getUsername()));
        }
        user.setPassword(passwordEncoder().encode(user.getPassword()));

        return userRepository.save(user);
    }

    public User login(User user, BindingResult bindingResult) {
        checkBindingResult(bindingResult);

        User userFromBase = findByUsername(user.getUsername());
        if (passwordEncoder().matches(user.getPassword(), userFromBase.getPassword())) {
            return userFromBase;
        }
        throw new InvalidDataException(invalid_password);
    }

    public User findByUsername(String username) {
        return getCheckedUser(userRepository.findByUsername(username));
    }

    private User getCheckedUser(Optional<User> user) {
        if (user.isEmpty()) {
            throw new NotFoundException(not_found_message);
        }
        return user.get();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getCheckedUser(userRepository.findByUsername(username));
    }
}
