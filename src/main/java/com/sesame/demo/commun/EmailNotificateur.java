package com.sesame.demo.commun;
public class EmailNotificateur implements Notificateur {
    @Override
    public void envoyer(String destinataire, String message) {
        System.out.println("[EMAIL] vers " + destinataire + " : " + message);
    }
}
