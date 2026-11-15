package tn.esprit.autoloc.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Contrat;
import tn.esprit.autoloc.service.IContratService;
import tn.esprit.autoloc.service.IContratServiceImp;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("contrat")
@Tag(name="gestion des contrats",description = "Crud")
public class ContratController {
    private final IContratService contratService;
    @Operation(summary = "ajouter un contrat")
    @PostMapping
    public Contrat ajouterContrat(@RequestBody Contrat contrat){
        return contratService.ajouterContrat(contrat);
    }
    @Operation(summary = "modifier un contrat")
    @PutMapping
    public Contrat modifierContrat(@RequestBody Contrat contrat){
        return contratService.modifierContrat(contrat );
    }
    @Operation(summary = "afficher les contrats")
    @GetMapping
    public List<Contrat> getall(){
        return contratService.ConsulterContrats();
    }
    @Operation(summary = "afficher le contrat par ID")
    @GetMapping("/getById/{id}")
    public Contrat getContartById(@PathVariable long id){
        return contratService.consulterContratById(id);
    }
    @Operation(summary = "supprimer un contrat")
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        contratService.supprimerContratById(id);
    }


}
