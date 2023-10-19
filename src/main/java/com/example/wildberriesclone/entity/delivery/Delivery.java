package com.example.wildberriesclone.entity.delivery;

import com.example.wildberriesclone.entity.AbstractEntity;
import com.example.wildberriesclone.entity.account.Order;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
@Setter @Getter
@Builder @AllArgsConstructor @NoArgsConstructor
public class Delivery extends AbstractEntity {
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @OneToOne
    private Order order;

    @OneToOne
    private PickUpPoint pickUpPoint;
}
