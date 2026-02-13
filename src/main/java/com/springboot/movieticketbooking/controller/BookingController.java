package com.springboot.movieticketbooking.controller;

import com.springboot.movieticketbooking.dto.BookingRequestDto;
import com.springboot.movieticketbooking.dto.BookingResponseDto;
import com.springboot.movieticketbooking.service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BookingController {
    
    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingResponseDto> bookSeats(@Valid @RequestBody BookingRequestDto request) {
        BookingResponseDto booking = bookingService.bookSeats(request);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<BookingResponseDto> getBookingById(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookingResponseDto>> getBookingsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(bookingService.getBookingsByUser(userId));
    }
}
