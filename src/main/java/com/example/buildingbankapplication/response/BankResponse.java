package com.example.buildingbankapplication.response;

import com.example.buildingbankapplication.response.AccountInfo;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankResponse {
    private String responseCode;

    private String responseMessage;

    private AccountInfo accountInfo;

    private BigDecimal accountBalance;

    private String accountNumber;

    private String accountName;



}
