package com.example.movieinfoservice.resources;

import com.example.movieinfoservice.modules.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieResource {

    @RequestMapping("/{movieId}")
    public Movie geMovie(@PathVariable("movieId") String movieId) {
        return new Movie(movieId, "name1");
    }
}
