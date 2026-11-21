package com.sesame.demo.injection;

import com.sesame.demo.commun.Outils;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoModes {
    public static void main(String[] args) {
        Outils.silence();
        try (AnnotationConfigApplicationContext ctx =
                     new AnnotationConfigApplicationContext(Config.class)) {
            // On demande chaque service et on affiche le notificateur reçu
            System.out.println(ctx.getBean(ServiceConstructeur.class).decrire());
            System.out.println(ctx.getBean(ServiceSetter.class).decrire());
            System.out.println(ctx.getBean(ServiceChamp.class).decrire());
        } catch (BeansException e) {
            // En cas de problème d'injection, on affiche la cause profonde
            Throwable cause = e.getMostSpecificCause();
            System.out.println("Erreur : " + cause.getClass().getSimpleName());
            System.out.println(cause.getMessage());
        }
    }
}