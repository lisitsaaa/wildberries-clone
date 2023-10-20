package com.example.wildberriesclone.mapper;

import com.example.wildberriesclone.dto.card.CardDto;
import com.example.wildberriesclone.entity.account.user.Card;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardMapper {
    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

    Card dtoToCard(CardDto dto);
    CardDto cardToDto(Card card);
}
