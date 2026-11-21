package com.sesame.librairie.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le titre est obligatoire")
    @Size(max = 200, message = "Le titre ne doit pas dépasser 200 caractères")
    @Column(nullable = false, length = 200)
    private String titre;

    @NotBlank(message = "L'auteur est obligatoire")
    private String auteur;

    @Min(value = 1, message = "L'année doit être comprise entre 1 et 2100")
    @Max(value = 2100, message = "L'année doit être comprise entre 1 et 2100")
    private int annee;


    // Constructeur vide
    public Livre() {
    }

    // Constructeur avec tous les attributs
    public Livre(Long id, String titre, String auteur, int annee) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.annee = annee;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
}
