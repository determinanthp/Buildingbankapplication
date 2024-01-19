package com.example.buildingbankapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Payment_Wallet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long walletId;

    private BigDecimal balance;

    @OneToOne(cascade = CascadeType.ALL)
    private  Customer customer;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction")
    private List<Transaction> transaction;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "account")
    private List<Account> accounts;

    @OneToMany
    @JsonIgnore
    @JoinColumn(name = "customer")
    private List<BillPayment> billPayments;

    @OneToMany
    @JsonIgnore
    @JoinColumn(name = "customer")
    private List<BeneficiaryDetail> beneficiaryDetails;

    private String accountWallet;

}
