package com.springboot.movieticketbooking.service;

import com.springboot.movieticketbooking.dto.TheatreDto;
import com.springboot.movieticketbooking.model.Theatre;
import com.springboot.movieticketbooking.repository.TheatreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TheatreService {
    
    private final TheatreRepository theatreRepository;
    
    public List<TheatreDto> getAllTheatres() {
        return theatreRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    
    public TheatreDto getTheatreById(Long id) {
        Theatre theatre = theatreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Theatre not found with id: " + id));
        return convertToDto(theatre);
    }
    
    private TheatreDto convertToDto(Theatre theatre) {
        return new TheatreDto(
                theatre.getId(),
                theatre.getName(),
                theatre.getLocation()
        );
    }
}
