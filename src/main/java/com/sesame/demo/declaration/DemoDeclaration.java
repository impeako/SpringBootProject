package com.sesame.demo.declaration;

import com.sesame.demo.commun.Notificateur;
import com.sesame.demo.commun.Outils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoDeclaration {
    public static void main(String[] args) {
        Outils.silence();
        try (AnnotationConfigApplicationContext ctx =
                     new AnnotationConfigApplicationContext(Config.class)) {
            // Quels beans existent ?
            System.out.println("Beans : " + Outils.beans(ctx));
            // Deux beans du même type : on les demande PAR LEUR NOM
            Notificateur email = ctx.getBean("notificateur", Notificateur.class);
            Notificateur sms = ctx.getBean("alerteSms", Notificateur.class);
            email.envoyer("amine@sesame.tn", "Bienvenue");
            sms.envoyer("amine@sesame.tn", "Bienvenue");
        }
    }
}