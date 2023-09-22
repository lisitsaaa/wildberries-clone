package com.example.wildberriesclone.entity.account.user;

import com.example.wildberriesclone.entity.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity @Table
@Setter @Getter
@Builder @AllArgsConstructor @NoArgsConstructor
public class Card extends AbstractEntity {
    @ManyToOne
    @JsonIgnore
    private User user;
    private String number;
}
