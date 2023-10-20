package com.example.wildberriesclone.wrapper;

import com.example.wildberriesclone.dto.user.RegDto;
import com.example.wildberriesclone.dto.user.UserDto;
import com.example.wildberriesclone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import static com.example.wildberriesclone.mapper.UserMapper.INSTANCE;

@Component
@RequiredArgsConstructor
public class UserWrapper {
    private final UserService userService;

    public UserDto save(RegDto regDto, BindingResult bindingResult){
        return INSTANCE.userToDto(
                        userService.save(
                                INSTANCE.regDtoToUser(regDto), bindingResult));
    }
}
