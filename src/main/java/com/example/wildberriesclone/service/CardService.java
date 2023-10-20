package com.example.wildberriesclone.service;

import com.example.wildberriesclone.entity.account.user.Card;
import com.example.wildberriesclone.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CardService {
    @Value("${NOT_FOUND}") private String not_found_message;
    @Value("${EXISTED}") private String existed_message;

    private final CardRepository cardRepository;

    public Card save(Card card) {
        return cardRepository.save(card);
    }
}
