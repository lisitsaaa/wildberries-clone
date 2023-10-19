package com.example.wildberriesclone.entity.product.commet;

import com.example.wildberriesclone.entity.AbstractEntity;
import com.example.wildberriesclone.entity.account.user.User;
import com.example.wildberriesclone.entity.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
@Setter @Getter
@Builder @AllArgsConstructor @NoArgsConstructor
public class Comment extends AbstractEntity {
    private String description;
    private LocalDate date;
    private Rating rating;

    @OneToOne
    private User user;

    @ManyToOne
    @JsonIgnore
    private Product product;
}
