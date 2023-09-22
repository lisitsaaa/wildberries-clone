package com.example.wildberriesclone.entity.delivery;

import com.example.wildberriesclone.entity.AbstractEntity;
import com.example.wildberriesclone.entity.account.Order;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table
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
