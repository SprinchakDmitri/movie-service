package com.daa.movieservice.service;

import com.daa.movieservice.api.dto.*;
import com.daa.movieservice.model.Country;
import com.daa.movieservice.model.Genre;
import com.daa.movieservice.model.Movie;
import com.daa.movieservice.repository.MovieRepository;
import com.daa.movieservice.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.daa.movieservice.utils.MovieMapper.*;

@Service
@RequiredArgsConstructor
public class MovieService {
    @Autowired
    private final MovieRepository movieRepository;
    @Autowired
    private final ReviewRepository reviewRepository;


    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }


    public MovieDto getMovieById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.map(mapMovieToMovieDto).get();
    }


    public MovieDto getMovById(Long id) {
        return movieRepository
                .findById(id)
                .map(mapMovieToMovieDto)
                .get();
    }

    public List<ReviewDto> getReviews(Long id) {
        return reviewRepository.findReviewByMovieId(id)
                .stream()
                .map(mapReviewToReviewDto)
                .collect(Collectors.toList());
    }

    public List<ShortMovieDto> getTopMovies(Integer number) {
        List<ShortMovieDto> list = movieRepository.getTop(number)
                .stream()
                .map(mapMovieToShortMovieDto)
                .collect(Collectors.toList());

        for (ShortMovieDto smd : list) {
            smd.setRating(getMovScore(smd.getId())
                            .getScore());
        }
        return list;
    }

    public ScoreDto getMovScore(Long id){
        return new ScoreDto(movieRepository.getMovieScoresById(id));
    }

    public List<String> getMovieGenres(Long id) {
        return movieRepository.findById(id)
                .get().getGenres()
                .stream()
                .map(Genre::getGenreName)
                .collect(Collectors.toList());

   }

    public List<String> getMovieCountries(Long id) {
        return movieRepository.findById(id)
                .get().getCountries()
                .stream()
                .map(Country::getCountryName)
                .collect(Collectors.toList());
    }

    public List<ShortMovieDto> searchByTitle(String title) {
        return movieRepository.findMoviesByMovieTitleContains(title)
                .stream()
                .limit(3)
                .map(mapMovieToShortMovieDto)
                .collect(Collectors.toList());
    }
}
