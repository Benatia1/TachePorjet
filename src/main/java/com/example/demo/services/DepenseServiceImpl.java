package com.example.demo.services;

import com.example.demo.jpa.entity.CategorieEntity;
import com.example.demo.jpa.entity.DepensesEntity;
import com.example.demo.jpa.repository.CategorieRepository;
import com.example.demo.jpa.repository.DepenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepenseServiceImpl implements DepenseService{
    @Autowired
    private DepenseRepo depenseRepo;
    @Autowired
    private CategorieRepository categorieRepository;

    @Override
    public List<DepensesEntity> getAllDepence() {
        return depenseRepo.findAll();
    }

    @Override
    public DepensesEntity ajoutDepence(DepensesEntity depenses) {
        CategorieEntity categorieExistante = categorieRepository.findByNom(depenses.getCategorie().getNom())
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée"));

        depenses.setCategorie(categorieExistante);

         return depenseRepo.save(depenses);
    }

    @Override
    public Optional<DepensesEntity> getDepencesByNom(String nom) {
        return depenseRepo.findAll().stream().filter(d->d.getNom().equals(nom)).findAny();
    }
}
