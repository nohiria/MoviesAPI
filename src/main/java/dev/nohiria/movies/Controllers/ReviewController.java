/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.nohiria.movies.Controllers;

import dev.nohiria.movies.Entities.Review;
import dev.nohiria.movies.Services.ReviewService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author nohyv
 */
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<>(reviewService.
                createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);
    }
}
