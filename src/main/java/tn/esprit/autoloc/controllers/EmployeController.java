package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("employe")
public class EmployeController {

    private final IEmployeService employeService;

    @PostMapping
    public Employe ajouterEmploye(@RequestBody Employe employe) {
        return employeService.ajouterEmploye(employe);
    }

    @PutMapping
    public Employe modifierEmploye(@RequestBody Employe employe) {
        return employeService.modifierEmploye(employe);
    }

    @GetMapping
    public List<Employe> consulterEmployes() {
        return employeService.consulterEmployes();
    }

    @GetMapping("/getById/{id}")
    public Employe consulterEmployeById(@PathVariable long id) {
        return employeService.consulterEmployeById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimerEmployeById(@PathVariable long id) {
        employeService.supprimerEmployeById(id);
    }
}
