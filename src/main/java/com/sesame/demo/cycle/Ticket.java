package com.sesame.demo.cycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // une NOUVELLE instance à chaque demande
public class Ticket {
    @PostConstruct
    void initialiser() {
        System.out.println("Ticket : cree");
    }

    // Spring n'appelle JAMAIS cette méthode pour un prototype (voir plus bas)
    @PreDestroy
    void nettoyer() {
        System.out.println("Ticket : detruit");
    }
}
