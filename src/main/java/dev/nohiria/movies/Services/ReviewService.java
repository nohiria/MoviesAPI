/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.nohiria.movies.Services;

import dev.nohiria.movies.Entities.Movie;
import dev.nohiria.movies.Entities.Review;
import dev.nohiria.movies.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 *
 * @author nohyv
 */
@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public Review createReview(String reviewBody, String imdbId) {
        
        Review review = reviewRepository.insert(new Review(reviewBody));
        
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();
        
        return review;
    }
}
