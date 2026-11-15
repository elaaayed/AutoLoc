package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.entities.Agence;
import tn.esprit.autoloc.entities.Vehicule;
import tn.esprit.autoloc.repositories.AgenceRepository;
import tn.esprit.autoloc.repositories.VehiculeRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class IAgenceServiceImp implements IAgenceService {

    private final AgenceRepository agenceRepository;
    private final VehiculeRepository vehiculeRepository;

    @Override
    public Agence ajouterAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence modifierAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public List<Agence> consulterAgences() {
        return agenceRepository.findAll();
    }

    @Override
    public Agence consulterAgenceById(long id) {
        return agenceRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerAgenceById(long id) {
        agenceRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Agence ajouterAgenceEtAffecterVehicules(Agence agence) {
        Set<Vehicule> vehicules = Optional.ofNullable(agence.getVehicules()).orElse(null);
        agence.setVehicules(new HashSet<>());
        Agence agenceEnregistree = agenceRepository.save(agence);
        if (vehicules != null) {
            vehicules.forEach(vehicule -> {
                vehicule.setAgence(agenceEnregistree);
                agenceEnregistree.getVehicules().add(vehiculeRepository.save(vehicule));
            });
        }
        return agenceEnregistree;
    }
}
