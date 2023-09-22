package com.example.wildberriesclone.entity.delivery;

import com.example.wildberriesclone.entity.AbstractEntity;
import com.example.wildberriesclone.entity.account.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity @Table
@Setter @Getter
@Builder @AllArgsConstructor @NoArgsConstructor
public class PickUpPoint extends AbstractEntity {
    @OneToOne
    private Address address;

    @OneToMany
    private List<User> managers;
}
