package com.springboot.movieticketbooking.repository;

import com.springboot.movieticketbooking.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    List<Theatre> findByNameContaining(String name);
    List<Theatre> findByLocationContaining(String location);
}
