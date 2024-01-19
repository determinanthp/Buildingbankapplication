package com.example.buildingbankapplication.repository;

import com.example.buildingbankapplication.entity.CurrentSessionUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<CurrentSessionUser, Long> {
}
