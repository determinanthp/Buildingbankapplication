package com.example.buildingbankapplication.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnquiryRequest {
    private String accountNumber;
    private BigDecimal accountBalance;
}
