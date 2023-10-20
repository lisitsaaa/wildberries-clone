package com.example.wildberriesclone.wrapper;

import com.example.wildberriesclone.dto.card.CardDto;
import com.example.wildberriesclone.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import static com.example.wildberriesclone.mapper.CardMapper.INSTANCE;

@Component
@RequiredArgsConstructor
public class CardWrapper {
    private final CardService cardService;

    public CardDto save(CardDto cardDto, UserDetails userDetails, BindingResult bindingResult){
        return INSTANCE.cardToDto(
                cardService.save(
                        INSTANCE.dtoToCard(cardDto), userDetails, bindingResult));
    }
}
