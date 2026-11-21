package com.sesame.demo.injection;

public class DemoHorsSpring {
    public static void main(String[] args) {
        // Constructeur : on est OBLIGÉ de fournir le notificateur
        ServiceConstructeur a = new ServiceConstructeur(new NotificateurEmail());
        System.out.println("Constructeur : " + a.decrire());
        // Champ : rien ne force à le remplir, Spring n'est pas là
        ServiceChamp b = new ServiceChamp();
        try {
            System.out.println("Champ : " + b.decrire());
        } catch (NullPointerException e) {
            System.out.println("Champ : NullPointerException");
        }
    }
}