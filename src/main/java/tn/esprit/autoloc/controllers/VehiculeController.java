package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("vehicule")
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @PostMapping
    public Vehicule ajouterVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.ajouterVehicule(vehicule);
    }

    @PutMapping
    public Vehicule modifierVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.modifierVehicule(vehicule);
    }

    @GetMapping
    public List<Vehicule> consulterVehicules() {
        return vehiculeService.consulterVehicules();
    }

    @GetMapping("/getById/{id}")
    public Vehicule consulterVehiculeById(@PathVariable long id) {
        return vehiculeService.consulterVehiculeById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimerVehiculeById(@PathVariable long id) {
        vehiculeService.supprimerVehiculeById(id);
    }
}
