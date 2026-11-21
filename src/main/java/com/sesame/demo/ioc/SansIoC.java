package com.sesame.demo.ioc;

import com.sesame.demo.commun.EmailNotificateur;
import com.sesame.demo.commun.SmsNotificateur;

public class SansIoC {
    static class EmpruntService {
        // private final EmailNotificateur notificateur = new EmailNotificateur();
        private final SmsNotificateur notificateur = new SmsNotificateur();

        void emprunter(String etudiant, String livre) {
            System.out.println("Emprunt enregistre : " + livre);
            notificateur.envoyer(etudiant, "Vous avez emprunte " + livre);
        }
    }

    public static void main(String[] args) {
        new EmpruntService().emprunter("amine@sesame.tn", "Clean Code");
    }
}