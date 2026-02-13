package com.springboot.movieticketbooking.repository;

import com.springboot.movieticketbooking.model.ShowSeat;
import com.springboot.movieticketbooking.util.SeatStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    List<ShowSeat> findByShowId(Long showId);
    List<ShowSeat> findByShowIdAndStatus(Long showId, SeatStatus status);
    
    @Query("SELECT ss FROM ShowSeat ss WHERE ss.show.id = :showId AND ss.seatNumber IN :seatNumbers")
    List<ShowSeat> findByShowIdAndSeatNumbers(@Param("showId") Long showId, @Param("seatNumbers") List<String> seatNumbers);
    
    @Query("SELECT COUNT(ss) FROM ShowSeat ss WHERE ss.show.id = :showId AND ss.status = :status")
    long countByShowIdAndStatus(@Param("showId") Long showId, @Param("status") SeatStatus status);
}
