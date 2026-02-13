package com.springboot.movieticketbooking.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {
    
    private Long id;
    private String barcode;
    private LocalDateTime issuedAt;
    private Long bookingId;
}
