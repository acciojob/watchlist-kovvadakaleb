package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    HashMap<String,Movie> movieMap = new HashMap<>();
    HashMap<String,Director> directorMap = new HashMap<>();
    HashMap<String, List<String>> movieDirectorMap = new HashMap<>();
    public ResponseEntity<String> addMovie(Movie movie) {

          movieMap.put(movie.getName(),movie);

      return new ResponseEntity<>("Movie Added Successfully", HttpStatus.OK);
    }

    public ResponseEntity<String> addDirector(Director director) {

           directorMap.put(director.getName(),director);

       return new ResponseEntity<>("Director Added Successfully",HttpStatus.OK);
    }

    public ResponseEntity<String> addMovieDirectorPair(String movieName, String directorName) {
        List<String> movielist = new ArrayList<>();
       if(movieMap.containsKey(movieName) && directorMap.containsKey(directorName)){
          if(movieDirectorMap.containsKey(directorName)){
              movielist = movieDirectorMap.get(directorName);
          }
           movielist.add(movieName);
           movieDirectorMap.put(directorName,movielist);
       }
       return new ResponseEntity<>("MovieDirector added Successfully",HttpStatus.OK);
    }

    public ResponseEntity<Movie> getMovieByName(String movieName) {

        return  ResponseEntity.ok(movieMap.get(movieName));
    }

    public ResponseEntity<Director> getDirectorByName(String directorName) {

           return ResponseEntity.ok(directorMap.get(directorName));
       }

       public ResponseEntity<List<String>> getMoviesByDirectorName(String directorName) {

         return ResponseEntity.ok(movieDirectorMap.get(directorName));
     }


    public ResponseEntity<List<String>> findAllMovies() {
        List<String> movielist = new ArrayList<>();
        for(String movie:movieMap.keySet()){
            movielist.add(movie);
        }
        return ResponseEntity.ok(movielist);
    }

    public ResponseEntity<String> deleteDirectorByName(String directorName) {
     if(movieDirectorMap.containsKey(directorName)){
         List<String> movielist = movieDirectorMap.get(directorName);
         for(String movie : movielist){
             if(movieMap.containsKey(movie)){
                 movieMap.remove(movie);
             }
         }
         if(movieDirectorMap.containsKey(directorName)){
             movieDirectorMap.remove(directorName);
         }
         if(directorMap.containsKey(directorName)){
             directorMap.remove(directorName);
         }
     }
     return new ResponseEntity<>("Deleted Director Successfully",HttpStatus.OK);
    }

    public ResponseEntity<String> deleteAllDirectors() {
     for(String director : movieDirectorMap.keySet()){
         for(String movie : movieDirectorMap.get(director)){
             if(movieMap.containsKey(movie)){
                 movieMap.remove(movie);
             }
         }
     }
     directorMap.clear();
     movieDirectorMap.clear();
     return new ResponseEntity<>("Deleted All Directors and Movies Successfully",HttpStatus.OK);
    }
}
