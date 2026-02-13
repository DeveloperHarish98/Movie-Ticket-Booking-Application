package com.springboot.movieticketbooking.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    
    private Long id;
    private String title;
    private Integer durationMinutes;
    private String language;
    private String rating;
}
