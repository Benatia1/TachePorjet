package com.example.demo.jpa.repository;

import com.example.demo.jpa.entity.TacheEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TachRepository extends JpaRepository<TacheEntity, Long> {
}
