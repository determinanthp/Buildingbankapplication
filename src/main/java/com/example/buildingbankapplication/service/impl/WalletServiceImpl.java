package com.example.buildingbankapplication.service.impl;

import com.example.buildingbankapplication.response.BankResponse;
import com.example.buildingbankapplication.dto.CustomerRequest;
import com.example.buildingbankapplication.repository.WalletRepository;
import com.example.buildingbankapplication.service.WalletService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WalletServiceImpl implements WalletService {

    WalletRepository repository;

    @Override
    public BankResponse createAccount(CustomerRequest request) {
        return null;
    }

    @Override
    public BankResponse updateAccount(CustomerRequest request, Long id) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public BankResponse findById(Long id) {
        return null;
    }

    @Override
    public List<BankResponse> FindAll() {
        return null;
    }
}
