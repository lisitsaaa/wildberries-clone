package com.example.wildberriesclone.entity.product;

import com.example.wildberriesclone.entity.AbstractEntity;
import lombok.*;

import javax.persistence.Entity;

@Entity
@Setter @Getter
@Builder @AllArgsConstructor @NoArgsConstructor
public class ProductProperty extends AbstractEntity {
    private String name;
    private String description;
}
