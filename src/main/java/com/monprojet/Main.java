package com.monprojet;

import com.monprojet.model.Etudiant;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Etudiant> etudiants = new ArrayList<>();
        etudiants.add(new Etudiant("Jean", "Dupont", "Informatique"));
        etudiants.add(new Etudiant("Sophie", "Durand", "Réseaux"));
        etudiants.add(new Etudiant("Alice", "Lemoine", "Cybersécurité"));

        for (Etudiant e : etudiants) {
            System.out.println(e);
        }
    }
}

