package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Employe;
import tn.esprit.autoloc.repositories.EmployeRepository;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.entities.Agence;
import tn.esprit.autoloc.repositories.AgenceRepository;


import java.util.List;

@Service
@AllArgsConstructor
public class IEmployeServiceImp implements IEmployeService {

    private final EmployeRepository employeRepository;
    private final AgenceRepository agenceRepository;


    @Override
    public Employe ajouterEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe modifierEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public List<Employe> consulterEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public Employe consulterEmployeById(long id) {
        return employeRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerEmployeById(long id) {
        employeRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Employe desaffecterEmploye(Long idEmploye) {
        Employe employe=employeRepository.findById(idEmploye).orElse(null);
        employe.setAgence(null);
        return employeRepository.save(employe);
    }

    @Override
    @Transactional
    public Employe affecterEmploye(Long idEmploye, Long idAgence) {
        Employe employe=employeRepository.findById(idEmploye).orElse(null);
        Agence agence=agenceRepository.findById(idAgence).orElse(null);
        employe.setAgence(agence);
        return employeRepository.save(employe);
    }
}
