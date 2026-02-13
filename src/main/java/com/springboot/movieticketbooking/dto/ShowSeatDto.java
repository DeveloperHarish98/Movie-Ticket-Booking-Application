package com.springboot.movieticketbooking.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowSeatDto {
    
    private Long id;
    private String seatNumber;
    private String type;
    private Double price;
    private String status;
    private Long showId;
}
