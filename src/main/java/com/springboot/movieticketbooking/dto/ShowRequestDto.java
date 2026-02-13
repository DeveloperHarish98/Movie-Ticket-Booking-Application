package com.springboot.movieticketbooking.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowRequestDto {
    
    @NotNull(message = "Movie ID is required")
    private Long movieId;
    
    @NotNull(message = "Theatre ID is required")
    private Long theatreId;
    
    @NotNull(message = "Show time is required")
    private LocalDateTime showTime;
}
