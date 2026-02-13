package com.springboot.movieticketbooking.repository;

import com.springboot.movieticketbooking.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitleContaining(String title);
    List<Movie> findByLanguage(String language);
    List<Movie> findByRating(String rating);
    
    @Query("SELECT m FROM Movie m WHERE m.title LIKE %?1% OR m.language LIKE %?1%")
    List<Movie> searchMovies(String keyword);
}
