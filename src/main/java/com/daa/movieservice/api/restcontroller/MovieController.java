package com.daa.movieservice.api.restcontroller;

import com.daa.movieservice.api.dto.*;
import com.daa.movieservice.model.Movie;
import com.daa.movieservice.service.CrewService;
import com.daa.movieservice.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    @Autowired
    private final CrewService crewService;
    @Autowired
    private final MovieService movieService;

    @GetMapping("/all")
    public List<Movie> getAllMovies(){
        return movieService.getMovies();
    }

    @GetMapping("/{id}")
    public MovieDto getMovieById(@PathVariable Long id){
        return movieService.getMovieById(id);
    }

    @GetMapping("/getTop")
    public List<ShortMovieDto> getTop(@RequestParam(defaultValue = "2") Integer number){
        return movieService.getTopMovies(number);
    }

    @GetMapping("/getReviews")
    public List<ReviewDto> getReviews(@RequestParam(name = "filmId") Long id){
        return movieService.getReviews(id);
    }

    @GetMapping("/getFilm")
    public MovieDto getMovie(@RequestParam(name = "filmId") Long id){
        return movieService.getMovById(id);
    }

    @GetMapping("/getCrew")
    public List<CrewDto> getCrew(@RequestParam(name = "filmId") Long id){
        return crewService.getCrewByMovId(id);
    }

    @GetMapping("/getScore")
    public ScoreDto getMovieScore (@RequestParam(name = "filmId") Long id){
        return movieService.getMovScore(id);
    }
}

