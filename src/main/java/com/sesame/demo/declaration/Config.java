package com.sesame.demo.declaration;

import com.sesame.demo.commun.EmailNotificateur;
import com.sesame.demo.commun.Notificateur;
import com.sesame.demo.commun.SmsNotificateur;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    // Bean nommé "notificateur" (nom de la méthode par défaut)
    @Bean
    public Notificateur notificateur() {
        // EmailNotificateur n'a aucune annotation : @Bean permet
        // pourtant d'en faire un bean, sans modifier la classe.
        return new EmailNotificateur();
    }

    // Bean dont on CHOISIT le nom : "alerteSms" (et non "sms")
    @Bean(name = "alerteSms")
    public Notificateur sms() {
        return new SmsNotificateur();
    }
}
