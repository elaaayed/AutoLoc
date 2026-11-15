package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("agence")
public class AgenceController {

    private final IAgenceService agenceService;

    @PostMapping
    public Agence ajouterAgence(@RequestBody Agence agence) {
        return agenceService.ajouterAgence(agence);
    }

    @PutMapping
    public Agence modifierAgence(@RequestBody Agence agence) {
        return agenceService.modifierAgence(agence);
    }

    @GetMapping
    public List<Agence> consulterAgences() {
        return agenceService.consulterAgences();
    }

    @GetMapping("/getById/{id}")
    public Agence consulterAgenceById(@PathVariable long id) {
        return agenceService.consulterAgenceById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimerAgenceById(@PathVariable long id) {
        agenceService.supprimerAgenceById(id);
    }

    @PostMapping("/ajouterAgenceEtAffecterVehicules")
    public Agence ajouterAgenceEtAffecterVehicules(@RequestBody Agence agence) {
        return agenceService.ajouterAgenceEtAffecterVehicules(agence);
    }
}
