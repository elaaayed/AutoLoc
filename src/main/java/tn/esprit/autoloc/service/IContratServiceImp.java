package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Contrat;
import tn.esprit.autoloc.repositories.ContratRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IContratServiceImp implements IContratService
{
    /*@Autowired
    private ContratRepository contratRepository;
     */
    private final ContratRepository contratRepository;
    @Override
    public Contrat ajouterContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat modifierContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public List<Contrat> ConsulterContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat consulterContratById(long id) {
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerContratById(long id) {
        contratRepository.deleteById(id);

    }
}
