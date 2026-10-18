package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Paiement;

import java.util.List;

public interface IPaiementService {
    Paiement ajouterPaiement(Paiement paiement);

    Paiement modifierPaiement(Paiement paiement);

    List<Paiement> consulterPaiements();

    Paiement consulterPaiementById(long id);

    void supprimerPaiementById(long id);
}
