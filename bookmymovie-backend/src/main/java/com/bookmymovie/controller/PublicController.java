package com.bookmymovie.controller;

import com.bookmymovie.model.Banner;
import com.bookmymovie.model.Movie;
import com.bookmymovie.service.BannerService;
import com.bookmymovie.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/movieApp")
public class PublicController {
    private final MovieService movieService;
    private final BannerService bannerService;

    public PublicController(MovieService service, BannerService bannerService) {
        this.movieService = service;
        this.bannerService = bannerService;
    }
        @GetMapping({"", "/"})
        public Map<String, String> root() {
            return Map.of(
                    "status", "ok",
                    "service", "BookMyMovie Backend"
            );
        }

        @GetMapping("/health")
        public Map<String, String> health() {
            return Map.of("status", "UP");
        }

        @GetMapping("/movies")
        public List<Movie> getAllMovies() {
            return movieService.getAllMovies();
        }

        @GetMapping("/banner")
        public Banner getBanner() {
            return bannerService.createBanner();
        }
}
