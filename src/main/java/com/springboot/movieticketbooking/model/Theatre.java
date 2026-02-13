package com.springboot.movieticketbooking.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Entity
@Table(name = "theatres")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theatre {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;
    
    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Seat> seats;
}
