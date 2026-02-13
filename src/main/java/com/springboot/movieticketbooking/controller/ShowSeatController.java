package com.springboot.movieticketbooking.controller;

import com.springboot.movieticketbooking.dto.ShowSeatDto;
import com.springboot.movieticketbooking.service.ShowSeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/show-seats")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ShowSeatController {
    
    private final ShowSeatService showSeatService;
    
    @GetMapping("/show/{showId}/available")
    public ResponseEntity<List<ShowSeatDto>> getAvailableSeats(@PathVariable Long showId) {
        return ResponseEntity.ok(showSeatService.getAvailableSeats(showId));
    }
    
    @GetMapping("/show/{showId}")
    public ResponseEntity<List<ShowSeatDto>> getSeatsByShow(@PathVariable Long showId) {
        return ResponseEntity.ok(showSeatService.getSeatsByShow(showId));
    }
}
