package com.daa.movieservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestsTest {
//    @Autowired
//    MovieController movieController;
//    @Autowired
//    PersonController personController;
//    @Autowired
//    PersonPageController personPageController;
//    @Autowired
//    MoviePageController moviePageController;
//    @Autowired
//    AdminPageController adminPageController;
//    @Autowired
//    AllMoviesPageController allMoviesPageController;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {

        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/movie/all",
                String.class)).isNotNull();
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/person/all",
                String.class)).isNotNull();
    }
}
