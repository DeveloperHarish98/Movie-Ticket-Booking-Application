package com.springboot.movieticketbooking.repository;

import com.springboot.movieticketbooking.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByTheatreId(Long theatreId);
    List<Seat> findByTheatreIdAndType(Long theatreId, String type);
}
