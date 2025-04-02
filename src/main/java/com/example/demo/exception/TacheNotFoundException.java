package com.example.demo.exception;

public class TacheNotFoundException extends RuntimeException{
    public TacheNotFoundException(Long id){
        super("Tache avec l'ID"+" "+id+" " + "non trouvée.");
    }
}
