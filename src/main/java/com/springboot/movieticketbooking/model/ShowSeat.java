package com.springboot.movieticketbooking.model;

import com.springboot.movieticketbooking.model.Seat;
import com.springboot.movieticketbooking.model.Show;
import com.springboot.movieticketbooking.util.SeatStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "show_seats")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowSeat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String seatNumber;

    @Column(nullable = false)
    private String type;
    
    @Column(nullable = false)
    private Double price;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatStatus status = SeatStatus.AVAILABLE;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id", nullable = false)
    private Show show;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;
    

}
