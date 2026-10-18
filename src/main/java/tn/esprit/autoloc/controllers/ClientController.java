package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("client")
public class ClientController {

    private final IClientService clientService;

    @PostMapping
    public Client ajouterClient(@RequestBody Client client) {
        return clientService.ajouterClient(client);
    }

    @PutMapping
    public Client modifierClient(@RequestBody Client client) {
        return clientService.modifierClient(client);
    }

    @GetMapping
    public List<Client> consulterClients() {
        return clientService.consulterClients();
    }

    @GetMapping("/getById/{id}")
    public Client consulterClientById(@PathVariable long id) {
        return clientService.consulterClientById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimerClientById(@PathVariable long id) {
        clientService.supprimerClientById(id);
    }
}
