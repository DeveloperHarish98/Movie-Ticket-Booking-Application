package com.springboot.movieticketbooking.controller;

import com.springboot.movieticketbooking.dto.ShowRequestDto;
import com.springboot.movieticketbooking.dto.ShowResponseDto;
import com.springboot.movieticketbooking.service.ShowService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shows")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ShowController {
    
    private final ShowService showService;
    
    @PostMapping
    public ResponseEntity<ShowResponseDto> createShow(@Valid @RequestBody ShowRequestDto request) {
        ShowResponseDto createdShow = showService.createShow(request);
        return new ResponseEntity<>(createdShow, HttpStatus.CREATED);
    }
    
    @GetMapping("/theatre/{theatreId}")
    public ResponseEntity<List<ShowResponseDto>> getShowsByTheatre(@PathVariable Long theatreId) {
        return ResponseEntity.ok(showService.getShowsByTheatre(theatreId));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ShowResponseDto> getShowById(@PathVariable Long id) {
        return ResponseEntity.ok(showService.getShowById(id));
    }
}
