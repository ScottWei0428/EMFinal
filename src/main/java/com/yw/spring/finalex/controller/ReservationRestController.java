package com.yw.spring.finalex.controller;

import com.yw.spring.finalex.model.Reservation;
import com.yw.spring.finalex.repository.ReservationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationRestController {

    private final ReservationRepository reservationRepository;

    public ReservationRestController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable String id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        return reservation.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable String id, @RequestBody Reservation updated) {
        return reservationRepository.findById(id)
                .map(existing -> {
                    existing.setFirstName(updated.getFirstName());
                    existing.setLastName(updated.getLastName());
                    existing.setPassengers(updated.getPassengers());
                    existing.setTravelClass(updated.getTravelClass());
                    existing.setPhoneNumber(updated.getPhoneNumber());
                    existing.setTime(updated.getTime());
                    existing.setDepartDate(updated.getDepartDate());
                    return ResponseEntity.ok(reservationRepository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
