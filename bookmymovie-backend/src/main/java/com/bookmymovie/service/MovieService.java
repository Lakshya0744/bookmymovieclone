package com.bookmymovie.service;

import com.bookmymovie.model.Movie;
import com.bookmymovie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        for(Movie movie : movies){
            String url = movie.getPosterUrl();
            movie.setPosterUrl(url);
        }
        return movies;
    }
    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }
    public Movie updateMovie(int id, Movie updatedMovie) {
        Movie existing = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id: " + id));

        // update fields
        existing.setTitle(updatedMovie.getTitle());
        existing.setDescription(updatedMovie.getDescription());
        existing.setPosterUrl(updatedMovie.getPosterUrl());

        return movieRepository.save(existing);
    }
    public void deleteMovie(int id){
        if(!movieRepository.existsById(id)){
            throw new RuntimeException("Movie not found" + id);
        }
        movieRepository.deleteById(id);
    }
}
