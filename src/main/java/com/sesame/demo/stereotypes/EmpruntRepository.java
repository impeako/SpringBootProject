package com.sesame.demo.stereotypes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

// Badge @Repository : cette classe est la couche des DONNÉES
@Repository
public class EmpruntRepository {
    // Une simple liste en mémoire joue le rôle de base de données
    private final List<String> emprunts = new ArrayList<>();

    public void ajouter(String livre) {
        emprunts.add(livre);
    }

    public int nombre() {
        return emprunts.size();
    }
}