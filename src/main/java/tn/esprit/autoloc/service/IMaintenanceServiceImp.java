package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.entities.Maintenance;
import tn.esprit.autoloc.repositories.MaintenanceRepository;
import tn.esprit.autoloc.repositories.VehiculeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IMaintenanceServiceImp implements IMaintenanceService {

    private final MaintenanceRepository maintenanceRepository;
    private final VehiculeRepository vehiculeRepository;

    // @Transactional : Maintenance -> Vehicule est en cascade PERSIST.
    // On recharge donc le véhicule (entité gérée) avant d'enregistrer, sinon
    // Hibernate lève "detached entity passed to persist".
    @Override
    @Transactional
    public Maintenance ajouterMaintenance(Maintenance maintenance) {
        if (maintenance.getVehicule() != null) {
            maintenance.setVehicule(
                    vehiculeRepository.findById(maintenance.getVehicule().getIdVehicule())
                            .orElseThrow(() -> new IllegalArgumentException("Véhicule introuvable")));
        }
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance modifierMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public List<Maintenance> consulterMaintenances() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Maintenance consulterMaintenanceById(long id) {
        return maintenanceRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerMaintenanceById(long id) {
        maintenanceRepository.deleteById(id);
    }
}
