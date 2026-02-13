package com.springboot.movieticketbooking.service;

import com.springboot.movieticketbooking.dto.MovieDto;
import com.springboot.movieticketbooking.model.Movie;
import com.springboot.movieticketbooking.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {
    
    private final MovieRepository movieRepository;
    
    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    
    public MovieDto getMovieById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id: " + id));
        return convertToDto(movie);
    }
    
    public List<MovieDto> searchMovies(String keyword) {
        return movieRepository.searchMovies(keyword).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    
    private MovieDto convertToDto(Movie movie) {
        return new MovieDto(
                movie.getId(),
                movie.getTitle(),
                movie.getDurationMinutes(),
                movie.getLanguage(),
                movie.getRating()
        );
    }
}
