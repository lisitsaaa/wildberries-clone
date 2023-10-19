package com.example.wildberriesclone.entity.account;

import com.example.wildberriesclone.entity.AbstractEntity;
import com.example.wildberriesclone.entity.account.user.User;
import com.example.wildberriesclone.entity.delivery.Address;
import com.example.wildberriesclone.entity.product.Product;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Setter @Getter
@Builder @AllArgsConstructor @NoArgsConstructor
public class Order extends AbstractEntity {
    @OneToOne
    private Product product;

    @OneToOne
    private User user;

    @OneToOne
    private Address address;
}
