package com.daa.movieservice.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class MovieDto {
    private Long id;
    private String movTitle;
    private String description;
    private String slogan;
    private Integer budget;
    private Integer duration;
    private String image;
    private Date premiereDate;
    private Date yearOfProd;
    private String ratingMppa;
    private String origLang;
    private Integer boxOffice;
    private String trailer;
    private Set<String> countries;
    private Set<String> genres;
}
