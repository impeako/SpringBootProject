package com.sesame.demo.stereotypes;

import org.springframework.stereotype.Controller;

// Badge @Controller : cette classe est la couche PRÉSENTATION (le guichet)
@Controller
public class EmpruntController {
    private final EmpruntService service;

    public EmpruntController(EmpruntService service) {
        this.service = service;
    }

    public void demander(String etudiant, String livre) {
        System.out.println("Requete recue : " + livre);
        service.emprunter(etudiant, livre);
    }
}