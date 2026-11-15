package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Employe;

import java.util.List;

public interface IEmployeService {
    Employe ajouterEmploye(Employe employe);

    Employe modifierEmploye(Employe employe);

    List<Employe> consulterEmployes();

    Employe consulterEmployeById(long id);

    void supprimerEmployeById(long id);

    Employe desaffecterEmploye(Long idEmploye);

    Employe affecterEmploye(Long idEmploye,Long idAgence);
}
