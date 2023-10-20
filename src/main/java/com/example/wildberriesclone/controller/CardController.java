package com.example.wildberriesclone.controller;

import com.example.wildberriesclone.dto.card.CardDto;
import com.example.wildberriesclone.service.CardService;
import com.example.wildberriesclone.wrapper.CardWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/card")
@RequiredArgsConstructor
public class CardController {
    private final CardWrapper cardWrapper;
    private final CardService cardService;

    @PostMapping
    public CardDto save(@RequestBody @Valid CardDto cardDto,
                        BindingResult bindingResult,
                        @AuthenticationPrincipal UserDetails userDetails){
        return cardWrapper.save(cardDto, userDetails, bindingResult);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id,
                       @AuthenticationPrincipal UserDetails userDetails){
        cardService.remove(id, userDetails);
    }
}
