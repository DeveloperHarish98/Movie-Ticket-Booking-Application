package com.springboot.movieticketbooking.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponseDto {
    
    private Long id;
    private LocalDateTime bookingTime;
    private Double totalAmount;
    private String status;
    private UserDto user;
    private ShowResponseDto show;
    private List<ShowSeatDto> showSeats;
    private TicketDto ticket;
}
