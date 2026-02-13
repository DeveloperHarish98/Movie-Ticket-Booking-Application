package com.springboot.movieticketbooking.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequestDto {
    
    @NotNull(message = "User ID is required")
    private Long userId;
    
    @NotNull(message = "Show ID is required")
    private Long showId;
    
    @NotEmpty(message = "Seat numbers cannot be empty")
    private List<String> seatNumbers;
}
