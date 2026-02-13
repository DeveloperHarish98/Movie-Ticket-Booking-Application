package com.springboot.movieticketbooking.repository;

import com.springboot.movieticketbooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId);
    List<Booking> findByShowId(Long showId);
    List<Booking> findByStatus(String status);
    
    @Query("SELECT b FROM Booking b WHERE b.user.id = :userId AND b.status = :status")
    List<Booking> findByUserAndStatus(@Param("userId") Long userId, @Param("status") String status);
}
