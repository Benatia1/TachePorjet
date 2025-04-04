package com.example.demo.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class RevenuEntity {
    @Id
    @GeneratedValue
    private Long id;

    private double montant;
    private LocalDate date;

    public Long getId(){
        return id;
    }

    public double getMontant(){
        return montant;
    }
    public void setMontant(double montant){
        this.montant = montant;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
