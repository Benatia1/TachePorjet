package com.example.demo.services;

import com.example.demo.jpa.entity.DepensesEntity;

import java.util.List;
import java.util.Optional;

public interface DepenseService {
    public List<DepensesEntity> getAllDepence();
    public DepensesEntity ajoutDepence(DepensesEntity depenses);
    public Optional<DepensesEntity> getDepencesByNom(String nom);
}
