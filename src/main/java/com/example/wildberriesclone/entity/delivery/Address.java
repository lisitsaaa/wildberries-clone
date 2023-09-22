package com.example.wildberriesclone.entity.delivery;

import com.example.wildberriesclone.entity.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity @Table
@Setter @Getter
@Builder @AllArgsConstructor @NoArgsConstructor
public class Address extends AbstractEntity {
    private String city;
    private String street;
    private String house;
}
