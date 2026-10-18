package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Contrat;
import tn.esprit.autoloc.service.IContratService;
import tn.esprit.autoloc.service.IContratServiceImp;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("contrat")
public class ContratController {
    private final IContratService contratService;
    @PostMapping
    public Contrat ajouterContrat(@RequestBody Contrat contrat){
        return contratService.ajouterContrat(contrat);
    }
    @PutMapping
    public Contrat modifierContrat(@RequestBody Contrat contrat){
        return contratService.modifierContrat(contrat );
    }
    @GetMapping
    public List<Contrat> getall(){
        return contratService.ConsulterContrats();
    }
    @GetMapping("/getById/{id}")
    public Contrat getContartById(@PathVariable long id){
        return contratService.consulterContratById(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        contratService.supprimerContratById(id);
    }


}
