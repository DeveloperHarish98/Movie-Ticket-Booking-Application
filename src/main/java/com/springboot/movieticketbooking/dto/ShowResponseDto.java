package com.springboot.movieticketbooking.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowResponseDto {
    
    private Long id;
    private LocalDateTime showTime;
    private MovieDto movie;
    private TheatreDto theatre;
    private Long totalSeats;
    private Long availableSeats;
}
