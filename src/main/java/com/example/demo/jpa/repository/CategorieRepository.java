package com.example.demo.jpa.repository;

import com.example.demo.jpa.entity.CategorieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategorieRepository extends JpaRepository<CategorieEntity, Long> {
    Optional<CategorieEntity> findByNom(String nom);
}
