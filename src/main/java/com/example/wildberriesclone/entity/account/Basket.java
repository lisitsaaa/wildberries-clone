package com.example.wildberriesclone.entity.account;

import com.example.wildberriesclone.entity.AbstractEntity;
import com.example.wildberriesclone.entity.account.user.User;
import com.example.wildberriesclone.entity.product.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity @Table
@Setter @Getter
@Builder @AllArgsConstructor @NoArgsConstructor
public class Basket extends AbstractEntity {
    @OneToOne
    private User user;

    @OneToMany
    private List<Product> products;
}
