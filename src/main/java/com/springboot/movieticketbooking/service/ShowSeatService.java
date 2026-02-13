package com.springboot.movieticketbooking.service;

import com.springboot.movieticketbooking.dto.ShowSeatDto;
import com.springboot.movieticketbooking.model.ShowSeat;
import com.springboot.movieticketbooking.repository.ShowSeatRepository;
import com.springboot.movieticketbooking.util.SeatStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShowSeatService {
    
    private final ShowSeatRepository showSeatRepository;
    
    public List<ShowSeatDto> getAvailableSeats(Long showId) {
        return showSeatRepository.findByShowIdAndStatus(showId, SeatStatus.AVAILABLE)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    
    public List<ShowSeatDto> getSeatsByShow(Long showId) {
        return showSeatRepository.findByShowId(showId)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    
    public List<ShowSeat> getShowSeatsByNumbers(Long showId, List<String> seatNumbers) {
        List<ShowSeat> showSeats = showSeatRepository.findByShowIdAndSeatNumbers(showId, seatNumbers);
        
        if (showSeats.size() != seatNumbers.size()) {
            throw new RuntimeException("Some seats not found for this show");
        }
        
        return showSeats;
    }
    
    private ShowSeatDto convertToDto(ShowSeat showSeat) {
        return new ShowSeatDto(
                showSeat.getId(),
                showSeat.getSeatNumber(),
                showSeat.getType(),
                showSeat.getPrice(),
                showSeat.getStatus().name(),
                showSeat.getShow().getId()
        );
    }
}
