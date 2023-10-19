package com.example.wildberriesclone.entity.product;

import com.example.wildberriesclone.entity.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Setter @Getter
@Builder @AllArgsConstructor @NoArgsConstructor
public class ProductProperty extends AbstractEntity {
    private String name;
    private String description;

    @ManyToOne
    @JsonIgnore
    private Product product;
}
