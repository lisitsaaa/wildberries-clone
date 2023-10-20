package com.example.wildberriesclone.mapper;

import com.example.wildberriesclone.dto.user.RegDto;
import com.example.wildberriesclone.dto.user.UserDto;
import com.example.wildberriesclone.entity.account.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User dtoToUser(UserDto dto);
    UserDto userToDto(User user);

    User regDtoToUser(RegDto dto);
}
