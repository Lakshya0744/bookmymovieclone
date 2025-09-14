package com.bookmymovie.controller;

import com.bookmymovie.model.Movie;
import com.bookmymovie.service.BannerService;
import com.bookmymovie.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/admin/movies")
public class AdminController {
    private final MovieService movieService;

    public AdminController(MovieService movieService, BannerService bannerService) {
        this.movieService = movieService;
    }
    @GetMapping({"", "/"})
    public Map<String, String> root() {
        return Map.of(
                "status", "ok",
                "service", "BookMyMovie Backend"
        );
    }
    @PostMapping("/addMovie")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie saved = movieService.addMovie(movie);
        return ResponseEntity.ok(saved);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(
            @PathVariable int id,
            @RequestBody Movie updatedMovie) {
        Movie saved = movieService.updateMovie(id, updatedMovie);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable int id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok("Movie deleted with id: " + id);
    }
}
