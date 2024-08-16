package com.project.reservation.service;

import com.project.reservation.model.Reservation;
import com.project.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public String makeReservation(String customerName, LocalDate date) {
        if (date.getDayOfWeek() == DayOfWeek.WEDNESDAY || date.getDayOfWeek() == DayOfWeek.FRIDAY) {
            return "Reservations are not allowed on Wednesdays and Fridays.";
        }

        List<Reservation> reservations = reservationRepository.findByDate(date);
        if (reservations.size() >= 2) {
            return "Reservations are fully booked for this date.";
        }

        Reservation reservation = new Reservation();
        reservation.setCustomerName(customerName);
        reservation.setDate(date);
        reservationRepository.save(reservation);

        return "Reservation confirmed for " + customerName + " on " + date;
    }

    public List<Reservation> getWeeklyReservations(LocalDate startDate) {
        LocalDate endDate = startDate.plusDays(6);
        return reservationRepository.findByDateBetween(startDate, endDate);
    }
}

