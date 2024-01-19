package com.example.buildingbankapplication.service;

import com.example.buildingbankapplication.response.BankResponse;
import com.example.buildingbankapplication.dto.CustomerRequest;

import java.util.List;

public interface WalletService {

    BankResponse createAccount(CustomerRequest request);

    BankResponse updateAccount(CustomerRequest request, Long id);

    boolean deleteById(Long id);

    BankResponse findById(Long id);

    List<BankResponse> FindAll();
}
