package com.daa.movieservice.utils;

import com.daa.movieservice.api.dto.ArticleDto;
import com.daa.movieservice.model.Article;
import lombok.NoArgsConstructor;

import java.util.function.Function;

@NoArgsConstructor
public class MediaMapper {
    public static final Function<Article, ArticleDto> mapArticleToArticleDto = article -> ArticleDto.builder()
            .id(article.getId())
            .title(article.getArticleTitle())
            .content(article.getContent())
            .date(article.getPublicationDate())
            .negativeRatting(article.getNegativeRevRating())
            .positiveRatting(article.getPositiveRevRating())
            .build();
}
