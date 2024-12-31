package com.eazybytes.Cards.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Entity

@Setter@Getter@AllArgsConstructor@NoArgsConstructor@ToString
public class Cards extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cardId;
    private String mobileNumber;
    private String cardType;
    private String cardNumber;
    private int totalLimit;
    private int amountUsed;
    private int availableAmount;
}
