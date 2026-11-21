package com.sesame.demo.conteneur;

import com.sesame.demo.commun.EmailNotificateur;
import com.sesame.demo.commun.Notificateur;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Notificateur notificateur() {
        System.out.println("Creation de Notificateur");
        return new EmailNotificateur();
    }

    @Bean
    public EmpruntService empruntService(Notificateur notificateur) {
        return new EmpruntService(notificateur);
    }

    @Bean
    public EmpruntController empruntController(EmpruntService empruntService) {
        return new EmpruntController(empruntService);
    }
}