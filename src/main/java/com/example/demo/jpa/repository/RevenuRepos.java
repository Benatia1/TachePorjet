package com.example.demo.jpa.repository;

import com.example.demo.jpa.entity.RevenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevenuRepos extends JpaRepository<RevenuEntity, Long> {
}
