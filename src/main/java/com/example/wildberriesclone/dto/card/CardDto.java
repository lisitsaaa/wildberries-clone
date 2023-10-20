package com.example.wildberriesclone.dto.card;

import com.example.wildberriesclone.dto.user.UserInfoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
public class CardDto {
    private String number;
    private List<UserInfoDto> users;
}
