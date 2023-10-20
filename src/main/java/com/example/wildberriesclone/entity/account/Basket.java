package com.example.wildberriesclone.entity.account;

import com.example.wildberriesclone.entity.AbstractEntity;
import com.example.wildberriesclone.entity.account.user.User;
import com.example.wildberriesclone.entity.product.Product;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Setter @Getter
@Builder @AllArgsConstructor @NoArgsConstructor
public class Basket extends AbstractEntity {
    @OneToOne
    private User user;

    @OneToMany
    private List<Product> products;
}
