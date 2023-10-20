package com.example.wildberriesclone.entity.product;

import com.example.wildberriesclone.entity.AbstractEntity;
import com.example.wildberriesclone.entity.account.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter @Getter
@Builder @AllArgsConstructor @NoArgsConstructor
public class Product extends AbstractEntity {
    private String name;
    private String description;
    private double price;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Enumerated(value = EnumType.STRING)
    private ProductStatus status;

    @ManyToOne
    private User seller;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProductProperty> productProperties;
}
