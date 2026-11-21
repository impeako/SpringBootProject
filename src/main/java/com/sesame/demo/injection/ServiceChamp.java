package com.sesame.demo.injection;

import com.sesame.demo.commun.Notificateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceChamp {
    // MODE 3 : injection directe dans le champ privé.
    // Court à écrire, mais fragile : sans Spring, le champ reste null.
    @Autowired
    private Notificateur notificateur;

    public String decrire() {
        return getClass().getSimpleName() + " utilise "
                + notificateur.getClass().getSimpleName();
    }
}