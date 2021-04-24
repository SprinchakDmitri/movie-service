package com.daa.movieservice.repository;

import com.daa.movieservice.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findArticlesByMovieMovieTitle(String title);
    List<Article> findArticlesByMovieId(Long id);
}
