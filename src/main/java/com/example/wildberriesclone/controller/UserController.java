package com.example.wildberriesclone.controller;

import com.example.wildberriesclone.dto.user.RegDto;
import com.example.wildberriesclone.dto.user.UserDto;
import com.example.wildberriesclone.wrapper.UserWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserWrapper userWrapper;

    @PostMapping
    public UserDto registration(@RequestBody @Valid RegDto regDto,
                                BindingResult bindingResult){
        return userWrapper.save(regDto, bindingResult);
    }
}
