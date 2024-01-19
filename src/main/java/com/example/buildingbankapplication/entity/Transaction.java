package com.example.buildingbankapplication.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.jetbrains.annotations.NotNull;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Transaction")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private TransactionType transactionType;

    @NotNull
    @CreatedDate
    @CreationTimestamp
    private LocalDateTime transactionDate;

    private double amount;

    private String description;

    @ManyToOne
    private  Wallet wallet;

    public String toString(){
        return "Transaction [transactionId=" + transactionId + ", transactionType=" + transactionType
                + ", transactionDate=" + transactionDate +", amount=" + amount
                + ", description=" + description +", wallet=" + wallet + "]";
    }
}
