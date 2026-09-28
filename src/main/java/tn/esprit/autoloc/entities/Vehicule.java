package tn.esprit.autoloc.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.autoloc.entities.enums.CategorieVehicule;
import tn.esprit.autoloc.entities.enums.StatutVehicule;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)

public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idVehicule;
    String immatriculation;
    String marque;
    String modele;
    @Enumerated(EnumType.STRING)
    CategorieVehicule categorie;

    BigDecimal tarifJournalier;

    @Enumerated(EnumType.STRING)
    StatutVehicule statut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="agence_id")
    Agence agence;

    @ManyToMany(fetch = FetchType.LAZY)
    Set<Equipement> equipements=new HashSet<>();

    @OneToMany(mappedBy ="vehicule",cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
    Set<Maintenance> maintenances = new HashSet<>();

    @OneToMany(mappedBy = "vehicule",fetch = FetchType.LAZY)
    Set<Reservation> reservations= new HashSet<>();
}