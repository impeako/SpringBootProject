package com.sesame.demo.cycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

// Pas de @Scope : le scope par défaut est "singleton" (une seule instance)
@Component
public class Compteur {
    private int valeur;

    public int incrementer() {
        return ++valeur; // augmente de 1 puis renvoie la nouvelle valeur
    }

    // Appelée UNE FOIS, juste après la création et l'injection
    @PostConstruct
    void initialiser() {
        System.out.println("Compteur : initialisation");
    }

    // Appelée UNE FOIS, à la fermeture du conteneur
    @PreDestroy
    void nettoyer() {
        System.out.println("Compteur : destruction");
    }
}