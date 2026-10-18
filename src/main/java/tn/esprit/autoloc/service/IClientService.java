package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Client;

import java.util.List;

public interface IClientService {
    Client ajouterClient(Client client);

    Client modifierClient(Client client);

    List<Client> consulterClients();

    Client consulterClientById(long id);

    void supprimerClientById(long id);
}
