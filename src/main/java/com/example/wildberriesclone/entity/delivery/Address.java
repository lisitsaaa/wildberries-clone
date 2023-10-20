package com.example.wildberriesclone.entity.delivery;

import com.example.wildberriesclone.entity.AbstractEntity;
import lombok.*;

import javax.persistence.Entity;

@Entity
@Setter @Getter
@Builder @AllArgsConstructor @NoArgsConstructor
public class Address extends AbstractEntity {
    private String city;
    private String street;
    private String house;
}
