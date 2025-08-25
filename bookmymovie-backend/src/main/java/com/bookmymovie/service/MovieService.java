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
}
