package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")

public class MovieController {

    @Autowired
   MovieService service;
    @PostMapping("/add-movie")
    public ResponseEntity<String>  addMovie(@RequestBody Movie movie){
       return service.addMovie(movie);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String>  addDirector(@RequestBody Director director){
       return service.addDirector(director);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("m") String movieName,@RequestParam("d")  String directorName){
        return service.addMovieDirectorPair(movieName,directorName);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String movieName){
     return service.getMovieByName(movieName);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String directorName){
     return service.getDirectorByName(directorName);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String directorName){
     return service.getMoviesByDirectorName(directorName);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
       return service.findAllMovies();
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("d") String directorName){
      return service.deleteDirectorByName(directorName);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
      return service.deleteAllDirectors();
    }
}
