package com.example.wildberriesclone.entity.account.user;

import com.example.wildberriesclone.entity.AbstractEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter @Getter
@Builder @AllArgsConstructor @NoArgsConstructor
public class Card extends AbstractEntity {
    @ManyToMany
    @JoinTable(name = "user_cards",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new HashSet<>();

    private String number;
}
