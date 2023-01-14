package jaeger.de.miel.HelloThymeleaf;

import jaeger.de.miel.HelloThymeleaf.model.org.themoviedb.genre.movie.GenresResponse;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import reactor.core.publisher.Mono;

import java.io.File;

@SpringBootTest(classes = SpringBootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebClientTest {

    @Autowired
    private TheMovieDBService theMovieDBService;

    @Test
    public void testGenreMovieList() {

        Mono<GenresResponse> response = theMovieDBService.listMovieGenres();
        GenresResponse genres = response.block();
        genres.getGenres().forEach(genre -> System.out.println(genre.getName()));


//        response.subscribe(
//                successValue -> System.out.println(successValue),
//                error -> System.err.println(error.getMessage()),
//                () -> System.out.println("Mono consumed.")
//        );


    }

    @Autowired
    private Environment env;

    @Test
    public void test() {

        String cache = env.getProperty("spring.thymeleaf.cache");
        System.out.println(cache);

    }



}
