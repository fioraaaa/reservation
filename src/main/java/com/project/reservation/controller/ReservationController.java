package com.project.reservation.controller;

import com.project.reservation.dto.ReservationRequestDto;
import com.project.reservation.model.Reservation;
import com.project.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public String makeReservation(@RequestBody ReservationRequestDto reservationRequestDto) {
        LocalDate reservationDate = reservationRequestDto.getDate();
        return reservationService.makeReservation(reservationRequestDto.getCustomerName(), reservationDate);
    }

    @GetMapping("/week")
    public List<Reservation> getWeeklyReservations(@RequestParam String startDate) {
        LocalDate start = LocalDate.parse(startDate);
        return reservationService.getWeeklyReservations(start);
    }
}
