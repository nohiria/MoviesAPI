/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.nohiria.movies.Services;

import dev.nohiria.movies.Entities.Movie;
import dev.nohiria.movies.Repositories.MovieRepository;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nohyv
 */
@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }
    
    public Optional<Movie> singleMovie(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
