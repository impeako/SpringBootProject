package com.sesame.demo.di;

import com.sesame.demo.commun.EmailNotificateur;
import com.sesame.demo.commun.Notificateur;

public class DemoInjection {
    static class EmpruntService {
        private final Notificateur notificateur;

        EmpruntService(Notificateur notificateur) {
            this.notificateur = notificateur;
        }

        void emprunter(String etudiant, String livre) {
            System.out.println("Emprunt enregistre : " + livre);
            notificateur.envoyer(etudiant, "Vous avez emprunte " + livre);
        }
    }

    static class EmpruntController {
        private final EmpruntService service;

        EmpruntController(EmpruntService service) {
            this.service = service;
        }

        void demander(String etudiant, String livre) {
            System.out.println("Requete recue : " + livre);
            service.emprunter(etudiant, livre);
        }
    }

    public static void main(String[] args) {
        Notificateur notificateur = new EmailNotificateur();
        EmpruntService service = new EmpruntService(notificateur);
        EmpruntController controller = new EmpruntController(service);
        controller.demander("amine@sesame.tn", "Clean Code");
    }
}