package com.example.wildberriesclone.entity.account.user;

import com.example.wildberriesclone.entity.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Setter @Getter
@Builder @AllArgsConstructor @NoArgsConstructor
public class Card extends AbstractEntity {
    @ManyToOne
    @JsonIgnore
    private User user;
    private String number;
}
