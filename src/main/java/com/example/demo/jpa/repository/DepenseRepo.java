package com.example.demo.jpa.repository;

import com.example.demo.jpa.entity.DepensesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepenseRepo extends JpaRepository<DepensesEntity, Long> {
}
