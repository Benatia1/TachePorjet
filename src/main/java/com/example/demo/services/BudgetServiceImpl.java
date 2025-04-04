package com.example.demo.services;

import com.example.demo.jpa.entity.DepensesEntity;
import com.example.demo.jpa.entity.RevenuEntity;
import com.example.demo.jpa.repository.DepenseRepo;
import com.example.demo.jpa.repository.RevenuRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetServiceImpl implements BudgetService{
    @Autowired
    private RevenuRepos revenu;
    @Autowired
    private DepenseRepo depenses;

    @Override
    public double getTotalRevenu() {
        return revenu.findAll().stream().mapToDouble(RevenuEntity::getMontant).sum();
    }

    @Override
    public double getTotalDepenses() {
        return depenses.findAll().stream().mapToDouble(DepensesEntity::getMontant).sum();
    }

    @Override
    public double getSoldeRestant() {
        var solde = getTotalRevenu()-getTotalDepenses();
        return solde;
    }
}
