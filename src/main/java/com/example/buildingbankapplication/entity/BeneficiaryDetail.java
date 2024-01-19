package com.example.buildingbankapplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Entity
@Table(name = "BeneficiaryDetail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiaryDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long beneficiaryId;

    @NotBlank
    @NotNull
    @Size(min = 10, max = 25 , message = "Name length minimum 4 to 25")
    private String beneficiaryName;

    @NotBlank
    @NotNull
    @Size(min = 13, max = 13, message = "mobile number must be in 13")
    private String beneficiaryPhoneNo;

    private Integer walletId;
}
