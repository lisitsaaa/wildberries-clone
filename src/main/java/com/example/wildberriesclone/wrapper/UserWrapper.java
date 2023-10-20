package com.example.wildberriesclone.wrapper;

import com.example.wildberriesclone.contfiguration.security.jwt.JwtTokenProvider;
import com.example.wildberriesclone.dto.user.AuthDto;
import com.example.wildberriesclone.dto.user.RegDto;
import com.example.wildberriesclone.dto.user.TokenDto;
import com.example.wildberriesclone.dto.user.UserDto;
import com.example.wildberriesclone.entity.account.user.User;
import com.example.wildberriesclone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import static com.example.wildberriesclone.mapper.UserMapper.INSTANCE;

@Component
@RequiredArgsConstructor
public class UserWrapper {
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public UserDto save(RegDto regDto, BindingResult bindingResult){
        return INSTANCE.userToDto(
                        userService.save(
                                INSTANCE.regDtoToUser(regDto), bindingResult));
    }

    public TokenDto getToken(AuthDto authDto, BindingResult bindingResult){
        User user = userService.login(INSTANCE.authDtoToUser(authDto), bindingResult);
        return INSTANCE.stringToTokenDto(
                jwtTokenProvider.generateToken(user.getUsername(), user.getRoles()));

    }
}
