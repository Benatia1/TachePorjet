package com.example.demo.services;

import com.example.demo.jpa.entity.CategorieEntity;
import com.example.demo.jpa.entity.DepensesEntity;

import java.util.List;
import java.util.Optional;

public interface CategorieService {

    CategorieEntity ajouterCategorie(CategorieEntity categorie);
    List<CategorieEntity> getAllCategories();
    Optional<CategorieEntity> getCategorieByNom(String nom);
    List<DepensesEntity> getDespenseByCategorie(String nom);

}
