package com.sesame.demo.conteneur;

import com.sesame.demo.commun.Outils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoConteneur {
    public static void main(String[] args) {
        Outils.silence();
        System.out.println("Demarrage du conteneur...");
        try (AnnotationConfigApplicationContext ctx =
                     new AnnotationConfigApplicationContext(Config.class)) {
            System.out.println("Conteneur pret. Beans : " + Outils.beans(ctx));
            EmpruntController controller = ctx.getBean(EmpruntController.class);
            controller.demander("amine@sesame.tn", "Clean Code");
        }
    }
}