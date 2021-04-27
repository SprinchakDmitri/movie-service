package com.daa.movieservice.utils;

import com.daa.movieservice.api.dto.CrewDto;
import com.daa.movieservice.api.dto.MovieDto;
import com.daa.movieservice.api.dto.ReviewDto;
import com.daa.movieservice.api.dto.ShortMovieDto;
import com.daa.movieservice.model.*;
import com.daa.movieservice.repository.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor
public class MovieMapper {
    public static final Function<Movie, MovieDto> mapMovieToMovieDto = movie -> MovieDto.builder()
            .id(movie.getId())
            .movTitle(movie.getMovieTitle())
            .description(movie.getDescription())
            .slogan(movie.getSlogan())
            .budget(movie.getBudget())
            .duration(movie.getDuration())
            .premiereDate(movie.getPremiereDate())
            .yearOfProd(movie.getYearOfProduction())
            .ratingMppa(movie.getRatingMppa())
            .origLang(movie.getOriginalLanguage())
            .boxOffice(movie.getBoxOffice())
            .trailer(movie.getTrailer())
            .countries(movie.getCountries().stream().map(Country::getCountryName).collect(Collectors.toSet()))
            .genres(movie.getGenres().stream().map(Genre::getGenreName).collect(Collectors.toSet()))
            .build();

    public static final Function<Review, ReviewDto> mapReviewToReviewDto = review -> ReviewDto.builder()
            .id(review.getId())
            .content(review.getContent())
            .negativeRevRatting(review.getNegativeReviewRating())
            .positiveRevRatting(review.getPositiveReviewRating())
            .reviewTitle(review.getReviewTitle())
            .movieScore(review.getMovieScore())
            .publicationDate(review.getPublicationDate())
            .build();

    public static final Function<Movie, ShortMovieDto> mapMovieToShortMovieDto = movie -> ShortMovieDto.builder()
            .id(movie.getId())
            .movTitle(movie.getMovieTitle())
            .movIcon(movie.getImage())
            .countries(movie.getCountries().stream().map(Country::getCountryName).collect(Collectors.toSet()))
            .genres(movie.getGenres().stream().map(Genre::getGenreName).collect(Collectors.toSet()))
            .origName(movie.getMovieTitle())  //todo implement rating and image
            .build();

    public static final Function<Crew, CrewDto> mapCrewToCrewDto = crew -> CrewDto.builder()
            .id(crew.getId())
            .name(crew.getPerson().getFirstName() + " " + crew.getPerson().getLastName())
            .movieTitle(crew.getMovie().getMovieTitle())
            .personageName(crew.getPersonageName())
            .roleName(crew.getRole().getRoleName())
            .build();
}
