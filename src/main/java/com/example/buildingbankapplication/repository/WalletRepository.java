package com.example.buildingbankapplication.repository;

import com.example.buildingbankapplication.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
