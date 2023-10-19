package com.example.wildberriesclone.entity.delivery;

import com.example.wildberriesclone.entity.AbstractEntity;
import com.example.wildberriesclone.entity.account.user.User;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Setter @Getter
@Builder @AllArgsConstructor @NoArgsConstructor
public class PickUpPoint extends AbstractEntity {
    @OneToOne
    private Address address;

    @OneToMany
    private List<User> managers;
}
