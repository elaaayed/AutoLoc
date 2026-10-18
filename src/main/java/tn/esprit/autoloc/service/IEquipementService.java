package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Equipement;

import java.util.List;

public interface IEquipementService {
    Equipement ajouterEquipement(Equipement equipement);

    Equipement modifierEquipement(Equipement equipement);

    List<Equipement> consulterEquipements();

    Equipement consulterEquipementById(long id);

    void supprimerEquipementById(long id);
}
