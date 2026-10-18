package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Agence;

import java.util.List;

public interface IAgenceService {
    Agence ajouterAgence(Agence agence);

    Agence modifierAgence(Agence agence);

    List<Agence> consulterAgences();

    Agence consulterAgenceById(long id);

    void supprimerAgenceById(long id);
}
