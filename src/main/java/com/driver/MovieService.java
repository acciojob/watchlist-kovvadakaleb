package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository repository;
    public ResponseEntity<String> addMovie(Movie movie) {
        return repository.addMovie(movie);
    }

    public ResponseEntity<String> addDirector(Director director) {
        return repository.addDirector(director);
    }

    public ResponseEntity<String> addMovieDirectorPair(String movieName, String directorName) {
        return repository.addMovieDirectorPair(movieName,directorName);
    }


    public ResponseEntity<Movie> getMovieByName(String movieName) {
        return repository.getMovieByName(movieName);
    }

    public ResponseEntity<Director> getDirectorByName(String directorName) {
      return repository.getDirectorByName(directorName);
    }
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String directorName){
       return repository.getMoviesByDirectorName(directorName);
    }

    public ResponseEntity<List<String>> findAllMovies() {
        return repository.findAllMovies();
    }

    public ResponseEntity<String> deleteDirectorByName(String directorName) {
        return repository.deleteDirectorByName(directorName);
    }

    public ResponseEntity<String> deleteAllDirectors() {
        return repository.deleteAllDirectors();
    }
}
