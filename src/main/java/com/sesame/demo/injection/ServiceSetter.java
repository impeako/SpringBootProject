package com.sesame.demo.injection;

import com.sesame.demo.commun.Notificateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceSetter {
    // Pas final : le champ est rempli APRÈS la création de l'objet
    private Notificateur notificateur;

    // MODE 2 : injection par setter. Spring crée l'objet, puis appelle
    // cette méthode pour lui remettre le notificateur.
    @Autowired
    public void setNotificateur(Notificateur notificateur) {
        this.notificateur = notificateur;
    }

    public String decrire() {
        return getClass().getSimpleName() + " utilise "
                + notificateur.getClass().getSimpleName();
    }
}
