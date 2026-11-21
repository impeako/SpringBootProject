package com.sesame.demo.conteneur;

public class EmpruntController {
    private final EmpruntService service;

    public EmpruntController(EmpruntService service) {
        System.out.println("Creation de EmpruntController");
        this.service = service;
    }

    public void demander(String etudiant, String livre) {
        System.out.println("Requete recue : " + livre);
        service.emprunter(etudiant, livre);
    }
}
