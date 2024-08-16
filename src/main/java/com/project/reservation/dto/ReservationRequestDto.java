package com.project.reservation.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationRequestDto {
    private String customerName;
    private LocalDate date;

}
