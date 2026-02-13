package com.springboot.movieticketbooking.controller;

import com.springboot.movieticketbooking.dto.MovieDto;
import com.springboot.movieticketbooking.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MovieController {
    
    private final MovieService movieService;
    
    @GetMapping
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<MovieDto>> searchMovies(@RequestParam String keyword) {
        return ResponseEntity.ok(movieService.searchMovies(keyword));
    }
}
