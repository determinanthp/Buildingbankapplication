package com.example.buildingbankapplication.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountInfo {

    private String accountName;

    private BigDecimal accountBalance;

    private String accountNumber;
}
