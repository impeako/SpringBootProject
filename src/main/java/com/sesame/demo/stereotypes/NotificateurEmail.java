package com.sesame.demo.stereotypes;

import com.sesame.demo.commun.Notificateur;
import org.springframework.stereotype.Component;

// Badge @Component : composant générique (ni métier, ni données, ni web)
@Component
public class NotificateurEmail implements Notificateur {
    @Override
    public void envoyer(String destinataire, String message) {
        System.out.println("[EMAIL] vers " + destinataire + " : " + message);
    }
}