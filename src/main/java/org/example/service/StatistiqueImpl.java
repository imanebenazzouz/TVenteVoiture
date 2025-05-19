package org.example.service;

import org.example.Voiture;

import java.util.ArrayList;
import java.util.List;

public  class StatistiqueImpl implements Statistique{

    private final double SEUIL_REMISE_MAX = 20000.00;

    public  List<Voiture> voitures = new ArrayList<>();

    @Override
    public  void ajouter(Voiture voiture) {
        voitures.add(voiture);
    }

    /**
     * Calcul d'un prix dégressif en fonction du nombre de voitures :
     * 5% de remise supplémentaire sur chaque voiture à chaque fois que 5 voitures sont ajoutées
     * et une remise maxi de 20 000 euros.
     * @return le prix des voitures
     * @throws ArithmeticException s'il n'y a pas de voiture
     */
    @Override
    public int prix() throws ArithmeticException {
        double remise = 0;
        if (voitures.isEmpty())
            return 0;

        double prixTotalDesVoitures=0.00;

        for (Voiture voiture : voitures){
            prixTotalDesVoitures += voiture.getPrix();
        }

        // Calcul de la remise
        int nbreRemises = voitures.size() / 5;

         remise = 0.05 * nbreRemises * prixTotalDesVoitures;

        if (remise > SEUIL_REMISE_MAX) {
            remise = SEUIL_REMISE_MAX;
        }

        return (int) (prixTotalDesVoitures - remise);

    }
}
