package com.example.wildberriesclone.service;

import com.example.wildberriesclone.entity.account.user.Card;
import com.example.wildberriesclone.entity.account.user.User;
import com.example.wildberriesclone.exception.NotFoundException;
import com.example.wildberriesclone.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.util.Optional;
import java.util.Set;

import static com.example.wildberriesclone.service.util.Validator.checkBindingResult;

@Service
@Transactional
@RequiredArgsConstructor
public class CardService {
    @Value("${NOT_FOUND}") private String not_found_message;

    private final CardRepository cardRepository;
    private final UserService userService;

    public Card save(Card card, UserDetails userDetails, BindingResult bindingResult) {
        checkBindingResult(bindingResult);
        User user = userService.findByUsername(userDetails.getUsername());
        card.setUsers(Set.of(user));
        return cardRepository.save(card);
    }

    public void remove(long id, UserDetails userDetails){
        Card card = findById(id);
        for (User user : card.getUsers()){
            if (user.getUsername().equals(userDetails.getUsername())){
                cardRepository.delete(card);
            }
        }
    }

    private Card findById(long id){
        Optional<Card> card = cardRepository.findById(id);
        if (card.isEmpty()) {
            throw new NotFoundException(not_found_message);
        }
        return card.get();
    }
}
