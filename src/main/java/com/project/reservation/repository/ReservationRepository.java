package com.project.reservation.repository;

import com.project.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByDate(LocalDate date);
    List<Reservation> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
