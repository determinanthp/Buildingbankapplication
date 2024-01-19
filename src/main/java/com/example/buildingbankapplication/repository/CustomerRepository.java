package com.example.buildingbankapplication.repository;

import com.example.buildingbankapplication.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Boolean existsByEmail(String email);

    Boolean existsByAccountBalance(BigDecimal accountBalance);

    Customer findByAccountNumber(String accountNumber);

}
