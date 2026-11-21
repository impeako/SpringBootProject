package com.sesame.demo.injection;

import com.sesame.demo.commun.Notificateur;
import org.springframework.stereotype.Component;

@Component
public class NotificateurSms implements Notificateur {
    @Override
    public void envoyer(String destinataire, String message) {
        System.out.println("[SMS] vers " + destinataire + " : " + message);
    }
}