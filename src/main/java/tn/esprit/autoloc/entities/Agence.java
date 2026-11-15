package tn.esprit.autoloc.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)


public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idAgence;
    String nom;
    String ville;
    String adresse;
    String telephone;


    @JsonIgnore
    @OneToMany (mappedBy ="agence",fetch=FetchType.LAZY)
    Set<Employe> employes = new HashSet<>();

    @JsonIgnoreProperties("agence")
    @OneToMany (mappedBy ="agence",fetch=FetchType.LAZY)
    Set<Vehicule> vehicules= new HashSet<>();
}

