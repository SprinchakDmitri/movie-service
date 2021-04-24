package com.daa.movieservice.api.restcontroller;

import com.daa.movieservice.api.dto.ArticleDto;
import com.daa.movieservice.model.Article;
import com.daa.movieservice.service.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/media")
@RequiredArgsConstructor
public class MediaController {

    @Autowired
    private MediaService mdServ;

    @GetMapping("/all")
    public List<ArticleDto> getMedia(){
        return mdServ.getAllArticles();
    }

    @GetMapping("/movie/title/{title}")
    public List<ArticleDto> getArticlesByMovieTitle(@PathVariable(name = "title") String title){
        return mdServ.getArticlesByMovTitle(title);
    }

    @GetMapping("/movie/id/{id}")
    public List<ArticleDto> getArtByMovId(@PathVariable(name = "id") Long id){
        return mdServ.getArtByMovId(id);

    }

    @GetMapping("/getArticle")
    public ArticleDto getArtById(@RequestParam (name = "artId") Long id){
        return mdServ.getArtById(id);
    }

    @GetMapping("/getTop")
    public List<ArticleDto> getTopArticles(){
        return null;
    }
}
