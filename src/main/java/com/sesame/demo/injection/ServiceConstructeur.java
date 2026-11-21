package com.sesame.demo.injection;

import com.sesame.demo.commun.Notificateur;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ServiceConstructeur {
    // final : le champ est rempli une fois, à la création, et ne change plus
    private final Notificateur notificateur;

    // MODE 1 : injection par le constructeur (le plus sûr)
    // Un seul constructeur : @Autowired n'est pas nécessaire
    //public ServiceConstructeur(Notificateur notificateur) {
        //this.notificateur = notificateur;
    //}

    // @Qualifier désigne un bean précis, PAR SON NOM
    public ServiceConstructeur(
            @Qualifier("notificateurSms") Notificateur notificateur) {
        this.notificateur = notificateur;
    }

    // Dit quel notificateur a été reçu : prouve que l'injection a eu lieu
    public String decrire() {
        return getClass().getSimpleName() + " utilise "
                + notificateur.getClass().getSimpleName();
    }



}
