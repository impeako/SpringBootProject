package com.sesame.demo.commun;
public class SmsNotificateur implements Notificateur {
    @Override
    public void envoyer(String destinataire, String message) {
        System.out.println("[SMS] vers " + destinataire + " : " + message);
    }
}
