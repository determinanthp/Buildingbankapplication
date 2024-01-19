package com.example.buildingbankapplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "BillPayment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;

    private BillType billType;

    private TransactionType transactionType;

    private Double amount;

    private LocalDateTime time;

    private Integer walletId;
}
