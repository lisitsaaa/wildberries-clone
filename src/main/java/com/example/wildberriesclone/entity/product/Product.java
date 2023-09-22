package com.example.wildberriesclone.entity.product;

import com.example.wildberriesclone.entity.AbstractEntity;
import com.example.wildberriesclone.entity.account.user.User;
import com.example.wildberriesclone.entity.product.commet.Comment;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity @Table
@Setter @Getter
@Builder @AllArgsConstructor @NoArgsConstructor
public class Product extends AbstractEntity {
    private String name;
    private String description;
    private Category category;

    @OneToOne
    private User seller;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductProperty> productProperties;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Comment> comments;
}
