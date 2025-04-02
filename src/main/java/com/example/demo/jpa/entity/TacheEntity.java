package com.example.demo.jpa.entity;

import com.example.demo.services.EtatTach;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
public class TacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private EtatTach etatTach;

    public Long getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }

    public EtatTach getEtatTach(){
        return etatTach;
    }
    public void setEtatTach(EtatTach etatTach){
        this.etatTach=etatTach;
    }

}
