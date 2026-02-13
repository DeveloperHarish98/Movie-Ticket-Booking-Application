package com.springboot.movieticketbooking.service;

import com.springboot.movieticketbooking.dto.BookingRequestDto;
import com.springboot.movieticketbooking.dto.BookingResponseDto;
import com.springboot.movieticketbooking.dto.ShowSeatDto;
import com.springboot.movieticketbooking.dto.ShowResponseDto;
import com.springboot.movieticketbooking.dto.UserDto;
import com.springboot.movieticketbooking.dto.TicketDto;
import com.springboot.movieticketbooking.dto.MovieDto;
import com.springboot.movieticketbooking.dto.TheatreDto;
import com.springboot.movieticketbooking.model.Booking;
import com.springboot.movieticketbooking.model.ShowSeat;
import com.springboot.movieticketbooking.model.Ticket;
import com.springboot.movieticketbooking.model.User;
import com.springboot.movieticketbooking.repository.*;
import com.springboot.movieticketbooking.util.SeatStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService {
    
    private final BookingRepository bookingRepository;
    private final ShowRepository showRepository;
    private final UserRepository userRepository;
    private final ShowSeatService showSeatService;
    private final ShowSeatRepository showSeatRepository;
    private final ShowService showService;
    
    @Transactional
    public BookingResponseDto bookSeats(BookingRequestDto request) {
        var show = showRepository.findById(request.getShowId())
                .orElseThrow(() -> new RuntimeException("Show not found with id: " + request.getShowId()));
        
        var user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + request.getUserId()));
        
        List<ShowSeat> showSeats = showSeatService.getShowSeatsByNumbers(request.getShowId(), request.getSeatNumbers());
        
        validateSeatsAvailability(showSeats);
        
        markSeatsAsBooked(showSeats);
        
        Booking booking = createBooking(user, show, showSeats);
        
        Ticket ticket = createTicket(booking);
        
        booking.setTicket(ticket);
        
        Booking savedBooking = bookingRepository.save(booking);
        
        return convertToDto(savedBooking);
    }
    
    private void validateSeatsAvailability(List<ShowSeat> showSeats) {
        for (ShowSeat showSeat : showSeats) {
            if (showSeat.getStatus() != SeatStatus.AVAILABLE) {
                throw new RuntimeException("Seat " + showSeat.getSeatNumber() + " is not available");
            }
        }
    }
    
    private void markSeatsAsBooked(List<ShowSeat> showSeats) {
        showSeats.forEach(seat -> seat.setStatus(SeatStatus.BOOKED));
        showSeatRepository.saveAll(showSeats);
    }
    
    private Booking createBooking(com.springboot.movieticketbooking.model.User user, 
                                 com.springboot.movieticketbooking.model.Show show, 
                                 List<ShowSeat> showSeats) {
        Double totalAmount = showSeats.stream()
                .mapToDouble(ShowSeat::getPrice)
                .sum();
        
        Booking booking = new Booking();
        booking.setBookingTime(LocalDateTime.now());
        booking.setTotalAmount(totalAmount);
        booking.setStatus("CONFIRMED");
        booking.setUser(user);
        booking.setShow(show);
        booking.setShowSeats(showSeats);
        
        return booking;
    }
    
    private Ticket createTicket(Booking booking) {
        Ticket ticket = new Ticket();
        ticket.setBarcode(UUID.randomUUID().toString());
        ticket.setIssuedAt(LocalDateTime.now());
        ticket.setBooking(booking);
        
        return ticket;
    }
    
    public BookingResponseDto getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));
        return convertToDto(booking);
    }
    
    public List<BookingResponseDto> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    
    private BookingResponseDto convertToDto(Booking booking) {
        List<ShowSeatDto> showSeatDtos = booking.getShowSeats().stream()
                .map(showSeat -> new ShowSeatDto(
                        showSeat.getId(),
                        showSeat.getSeatNumber(),
                        showSeat.getType(),
                        showSeat.getPrice(),
                        showSeat.getStatus().name(),
                        showSeat.getShow().getId()
                ))
                .collect(Collectors.toList());
        
        // Reuse ShowService so totalSeats and availableSeats are consistent everywhere
        ShowResponseDto showDto = showService.getShowById(booking.getShow().getId());
        
        UserDto userDto = new UserDto(
                booking.getUser().getId(),
                booking.getUser().getName(),
                booking.getUser().getEmail(),
                booking.getUser().getPhone()
        );
        
        TicketDto ticketDto = null;
        if (booking.getTicket() != null) {
            ticketDto = new TicketDto(
                    booking.getTicket().getId(),
                    booking.getTicket().getBarcode(),
                    booking.getTicket().getIssuedAt(),
                    booking.getTicket().getBooking().getId()
            );
        }
        
        return new BookingResponseDto(
                booking.getId(),
                booking.getBookingTime(),
                booking.getTotalAmount(),
                booking.getStatus(),
                userDto,
                showDto,
                showSeatDtos,
                ticketDto
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
