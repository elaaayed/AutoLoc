package tn.esprit.autoloc.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)


public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idAgence;
    String nom;
    String ville;
    String adresse;
    String telephone;


    @OneToMany (mappedBy ="agence",fetch=FetchType.LAZY)
    Set<Employe> employes = new HashSet<>();

    @OneToMany (mappedBy ="agence",fetch=FetchType.LAZY)
    Set<Vehicule> vehicules= new HashSet<>();
}

