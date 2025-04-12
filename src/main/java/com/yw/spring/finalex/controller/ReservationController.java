package com.yw.spring.finalex.controller;

import com.yw.spring.finalex.model.Reservation;
import com.yw.spring.finalex.repository.ReservationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReservationController {

    private final ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "index";
    }

    @PostMapping("/reservation")
    public String saveReservation(@ModelAttribute Reservation reservation, Model model) {
        reservationRepository.save(reservation);
        model.addAttribute("reservation", reservation);
        return "success";
    }
}
