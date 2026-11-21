package com.sesame.demo.stereotypes;

import com.sesame.demo.commun.Notificateur;
import org.springframework.stereotype.Service;

// Badge @Service : cette classe est la couche MÉTIER
@Service
public class EmpruntService {
    private final EmpruntRepository repository;
    private final Notificateur notificateur;

    // Deux dépendances : Spring les fournit toutes les deux
    public EmpruntService(EmpruntRepository repository, Notificateur notificateur) {
        this.repository = repository;
        this.notificateur = notificateur;
    }

    public void emprunter(String etudiant, String livre) {
        repository.ajouter(livre); // 1) on range l'emprunt
        System.out.println("Emprunt enregistre : " + livre
                + " (" + repository.nombre() + " emprunt(s) en memoire)");
        // 2) on prévient l'étudiant
        notificateur.envoyer(etudiant, "Vous avez emprunte " + livre);
    }
}
