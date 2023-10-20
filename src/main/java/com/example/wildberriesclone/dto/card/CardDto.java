package com.example.wildberriesclone.dto.card;

import com.example.wildberriesclone.dto.user.UserCardInfoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
public class CardDto {
    private String number;
    private List<UserCardInfoDto> users;
}
