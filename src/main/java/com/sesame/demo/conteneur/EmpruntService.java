package com.sesame.demo.conteneur;

import com.sesame.demo.commun.Notificateur;

public class EmpruntService {
    private final Notificateur notificateur;

    public EmpruntService(Notificateur notificateur) {
        System.out.println("Creation de EmpruntService");
        this.notificateur = notificateur;
    }

    public void emprunter(String etudiant, String livre) {
        System.out.println("Emprunt enregistre : " + livre);
        notificateur.envoyer(etudiant, "Vous avez emprunte " + livre);
    }
}