package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Vehicule;

import java.util.List;

public interface IVehiculeService {
    Vehicule ajouterVehicule(Vehicule vehicule);

    Vehicule modifierVehicule(Vehicule vehicule);

    List<Vehicule> consulterVehicules();

    Vehicule consulterVehiculeById(long id);

    void supprimerVehiculeById(long id);

    Vehicule affecterEquipement(Long idVehicule, Long idEquipement);

    Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement);
}
