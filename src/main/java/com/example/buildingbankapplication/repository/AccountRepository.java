package com.example.buildingbankapplication.repository;

import com.example.buildingbankapplication.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
