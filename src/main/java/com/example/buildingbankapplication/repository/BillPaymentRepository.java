package com.example.buildingbankapplication.repository;

import com.example.buildingbankapplication.entity.BillPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillPaymentRepository extends JpaRepository<BillPayment, Long> {
}
