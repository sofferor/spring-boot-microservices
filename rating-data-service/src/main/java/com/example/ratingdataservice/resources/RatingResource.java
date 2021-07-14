package com.example.ratingdataservice.resources;

import com.example.ratingdataservice.modules.Rating;
import com.example.ratingdataservice.modules.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rating")
public class RatingResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 6);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        Map<String, UserRating> userIdToUserRating = new HashMap<>();
        userIdToUserRating.put(userId,
                new UserRating(userId,
                        Arrays.asList(
                                new Rating("movieId1", 1),
                                new Rating("movieId2", 2))));
        return userIdToUserRating.get(userId);
    }
}
