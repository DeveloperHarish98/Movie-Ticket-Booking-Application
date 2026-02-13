package com.springboot.movieticketbooking.repository;

import com.springboot.movieticketbooking.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findByTheatreId(Long theatreId);
    List<Show> findByMovieId(Long movieId);
    List<Show> findByShowTimeBetween(LocalDateTime start, LocalDateTime end);
    
    @Query("SELECT s FROM Show s WHERE s.theatre.id = :theatreId AND s.showTime BETWEEN :start AND :end")
    List<Show> findShowsByTheatreAndDateRange(@Param("theatreId") Long theatreId, 
                                             @Param("start") LocalDateTime start, 
                                             @Param("end") LocalDateTime end);
    
    @Query("SELECT s FROM Show s WHERE s.movie.id = :movieId AND s.showTime > :now")
    List<Show> findUpcomingShowsByMovie(@Param("movieId") Long movieId, @Param("now") LocalDateTime now);
}
