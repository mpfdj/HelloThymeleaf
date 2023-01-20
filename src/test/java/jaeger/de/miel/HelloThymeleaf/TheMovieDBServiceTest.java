package jaeger.de.miel.HelloThymeleaf;

import jaeger.de.miel.HelloThymeleaf.model.org.themoviedb.genre.movie.Genre;
import jaeger.de.miel.HelloThymeleaf.model.org.themoviedb.genre.movie.GenresResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = SpringBootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TheMovieDBServiceTest {

    @Autowired
    private TheMovieDBService theMovieDBService;

    @Test
    public void listMovieGenres() {
        Mono<GenresResponse> movieGenresResponse = theMovieDBService.listMovieGenres();
        List<Genre> movieGenres = movieGenresResponse.block().getGenres();
        movieGenres.forEach(mg -> System.out.println(mg.getName()));
    }

}