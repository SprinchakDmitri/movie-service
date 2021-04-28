package com.daa.movieservice;

import com.daa.movieservice.api.restcontroller.MovieController;
import com.daa.movieservice.api.restcontroller.PersonController;
import com.daa.movieservice.controller.AdminPageController;
import com.daa.movieservice.controller.AllMoviesPageController;
import com.daa.movieservice.controller.MoviePageController;
import com.daa.movieservice.controller.PersonPageController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class SmokeTest {
    @Autowired
    MovieController movieController;
    @Autowired
    PersonController personController;
    @Autowired
    PersonPageController personPageController;
    @Autowired
    MoviePageController moviePageController;
    @Autowired
    AdminPageController adminPageController;
    @Autowired
    AllMoviesPageController allMoviesPageController;

    @Test
    public void contextLoads()  {
        assertThat(movieController).isNotNull();
        assertThat(personController).isNotNull();
        assertThat(personPageController).isNotNull();
        assertThat(moviePageController).isNotNull();
        assertThat(adminPageController).isNotNull();
        assertThat(allMoviesPageController).isNotNull();
    }
}
