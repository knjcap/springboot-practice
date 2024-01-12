package com.tgp.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
@Entity
@Table
public class Corridor {
    @Id
    @SequenceGenerator(
            name = "corridor_sequence",
            sequenceName = "corridor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "corridor_sequence"
    )
    private Long id;
    private String sendCountry;
    private String sendCurrency;
    private String receiveCountry;
    private String receiveCurrency;
    private String payoutMethod;
    private String tenantId;
    private boolean isActive;
}
