package com.springboot.movieticketbooking.service;

import com.springboot.movieticketbooking.dto.ShowRequestDto;
import com.springboot.movieticketbooking.dto.ShowResponseDto;
import com.springboot.movieticketbooking.dto.TheatreDto;
import com.springboot.movieticketbooking.dto.MovieDto;
import com.springboot.movieticketbooking.model.Show;
import com.springboot.movieticketbooking.model.ShowSeat;
import com.springboot.movieticketbooking.model.Seat;
import com.springboot.movieticketbooking.repository.*;
import com.springboot.movieticketbooking.util.SeatStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShowService {
    
    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private final TheatreRepository theatreRepository;
    private final SeatRepository seatRepository;
    private final ShowSeatRepository showSeatRepository;
    
    @Transactional
    public ShowResponseDto createShow(ShowRequestDto request) {
        Show show = new Show();
        show.setShowTime(request.getShowTime());
        show.setMovie(movieRepository.findById(request.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie not found with id: " + request.getMovieId())));
        show.setTheatre(theatreRepository.findById(request.getTheatreId())
                .orElseThrow(() -> new RuntimeException("Theatre not found with id: " + request.getTheatreId())));
        
        Show savedShow = showRepository.save(show);
        createShowSeats(savedShow);
        return convertToDto(savedShow);
    }
    
    private void createShowSeats(Show show) {
        List<Seat> theatreSeats = seatRepository.findByTheatreId(show.getTheatre().getId());
        
        if (theatreSeats.isEmpty()) {
            throw new RuntimeException("No seats found for theatre with id: " + show.getTheatre().getId());
        }
        
        System.out.println("Creating " + theatreSeats.size() + " show seats for show: " + show.getId());
        
        List<ShowSeat> showSeats = theatreSeats.stream()
                .map(seat -> {
                    ShowSeat showSeat = new ShowSeat();
                    showSeat.setSeatNumber(seat.getSeatNumber());
                    showSeat.setType(seat.getType());
                    showSeat.setPrice(seat.getPrice());
                    showSeat.setStatus(SeatStatus.AVAILABLE);
                    showSeat.setShow(show);
                    showSeat.setSeat(seat);
                    return showSeat;
                })
                .collect(Collectors.toList());
        
        List<ShowSeat> savedShowSeats = showSeatRepository.saveAll(showSeats);
        System.out.println("Successfully created " + savedShowSeats.size() + " show seats");
    }
    
    @Transactional
    public List<ShowResponseDto> getShowsByTheatre(Long theatreId) {
        return showRepository.findByTheatreId(theatreId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    
    @Transactional
    public ShowResponseDto getShowById(Long id) {
        Show show = showRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show not found with id: " + id));
        return convertToDto(show);
    }
    
    private ShowResponseDto convertToDto(Show show) {
        long totalSeats = showSeatRepository.countByShowIdAndStatus(show.getId(), SeatStatus.AVAILABLE) +
                         showSeatRepository.countByShowIdAndStatus(show.getId(), SeatStatus.BOOKED) +
                         showSeatRepository.countByShowIdAndStatus(show.getId(), SeatStatus.LOCKED);

        // If this show has no ShowSeat entries yet (e.g. created via SQL seed script),
        // lazily create them now based on the theatre's seats.
        if (totalSeats == 0L) {
            createShowSeats(show);
            totalSeats = showSeatRepository.countByShowIdAndStatus(show.getId(), SeatStatus.AVAILABLE) +
                         showSeatRepository.countByShowIdAndStatus(show.getId(), SeatStatus.BOOKED) +
                         showSeatRepository.countByShowIdAndStatus(show.getId(), SeatStatus.LOCKED);
        }

        long availableSeats = showSeatRepository.countByShowIdAndStatus(show.getId(), SeatStatus.AVAILABLE);
        
        return new ShowResponseDto(
                show.getId(),
                show.getShowTime(),
                convertMovieToDto(show.getMovie()),
                convertTheatreToDto(show.getTheatre()),
                totalSeats,
                availableSeats
        );
    }
    
    private MovieDto convertMovieToDto(com.springboot.movieticketbooking.model.Movie movie) {
        return new MovieDto(
                movie.getId(),
                movie.getTitle(),
                movie.getDurationMinutes(),
                movie.getLanguage(),
                movie.getRating()
        );
    }
    
    private TheatreDto convertTheatreToDto(com.springboot.movieticketbooking.model.Theatre theatre) {
        return new TheatreDto(
                theatre.getId(),
                theatre.getName(),
                theatre.getLocation()
        );
    }
}
