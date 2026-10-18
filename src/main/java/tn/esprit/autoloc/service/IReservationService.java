package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation ajouterReservation(Reservation reservation);

    Reservation modifierReservation(Reservation reservation);

    List<Reservation> consulterReservations();

    Reservation consulterReservationById(long id);

    void supprimerReservationById(long id);
}
