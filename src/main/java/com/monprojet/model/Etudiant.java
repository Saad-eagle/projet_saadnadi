package com.monprojet.model;

public class Etudiant {
    private String nom;
    private String prenom;
    private String specialite;

    public Etudiant(String nom, String prenom, String specialite) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSpecialite() {
        return specialite;
    }

    @Override
    public String toString() {
        return prenom + " " + nom + " - " + specialite;
    }
}

