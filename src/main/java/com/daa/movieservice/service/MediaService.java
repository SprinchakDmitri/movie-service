package com.daa.movieservice.service;

import com.daa.movieservice.api.dto.ArticleDto;
import com.daa.movieservice.model.Article;
import com.daa.movieservice.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.daa.movieservice.utils.MediaMapper.mapArticleToArticleDto;

@Service
@RequiredArgsConstructor
public class MediaService {
    @Autowired
    private ArticleRepository artRep;

    public List<ArticleDto> getAllArticles(){
        return artRep.findAll().stream().map(mapArticleToArticleDto).collect(Collectors.toList());
    }

    public List<ArticleDto> getArticlesByMovTitle(String title) {
        return artRep.findArticlesByMovieMovieTitle(title)
                .stream()
                .map(mapArticleToArticleDto)
                .collect(Collectors.toList());
    }

    public List<ArticleDto> getArtByMovId(Long id) {
        return artRep.findArticlesByMovieId(id).stream()
                .map(mapArticleToArticleDto)
                .collect(Collectors.toList());
    }

    public ArticleDto getArtById(Long id) {
        return artRep.findById(id).map(mapArticleToArticleDto).get();
    }
}
