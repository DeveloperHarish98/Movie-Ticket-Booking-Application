package com.springboot.movieticketbooking.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheatreDto {
    
    private Long id;
    private String name;
    private String location;
}
