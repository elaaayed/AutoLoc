package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Reservation;
import tn.esprit.autoloc.service.IReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("reservation")
public class ReservationController {

    private final IReservationService reservationService;

    @PostMapping
    public Reservation ajouterReservation(@RequestBody Reservation reservation) {
        return reservationService.ajouterReservation(reservation);
    }

    @PutMapping
    public Reservation modifierReservation(@RequestBody Reservation reservation) {
        return reservationService.modifierReservation(reservation);
    }

    @GetMapping
    public List<Reservation> consulterReservations() {
        return reservationService.consulterReservations();
    }

    @GetMapping("/getById/{id}")
    public Reservation consulterReservationById(@PathVariable long id) {
        return reservationService.consulterReservationById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimerReservationById(@PathVariable long id) {
        reservationService.supprimerReservationById(id);
    }
}
