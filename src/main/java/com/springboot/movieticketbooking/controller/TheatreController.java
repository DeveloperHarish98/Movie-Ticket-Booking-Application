package com.springboot.movieticketbooking.controller;

import com.springboot.movieticketbooking.dto.TheatreDto;
import com.springboot.movieticketbooking.service.TheatreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theatres")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TheatreController {
    
    private final TheatreService theatreService;
    
    @GetMapping
    public ResponseEntity<List<TheatreDto>> getAllTheatres() {
        return ResponseEntity.ok(theatreService.getAllTheatres());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TheatreDto> getTheatreById(@PathVariable Long id) {
        return ResponseEntity.ok(theatreService.getTheatreById(id));
    }
}
