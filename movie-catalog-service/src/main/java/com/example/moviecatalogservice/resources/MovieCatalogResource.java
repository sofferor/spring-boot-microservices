package com.example.moviecatalogservice.resources;

import com.example.moviecatalogservice.modules.CatalogItem;
import com.example.moviecatalogservice.modules.Movie;
import com.example.moviecatalogservice.modules.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        List<String> movieIds = Arrays.asList("id1", "id2");
        List<Rating> ratings = movieIds.stream().map(movieId -> {
            return restTemplate.getForObject("http://localhost:8083/rating/" + movieId, Rating.class);
        }).collect(Collectors.toList());

        List<CatalogItem> catalogItems = ratings.stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://localhost:8082/movie/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
        }).collect(Collectors.toList());

        return catalogItems;
    }
}
