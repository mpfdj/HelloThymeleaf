package jaeger.de.miel.HelloThymeleaf;

import jaeger.de.miel.HelloThymeleaf.model.org.themoviedb.genre.movie.GenresResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = SpringBootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebClientTest {

    @Autowired
    private TheMovieDBService theMovieDBService;

    @Autowired
    private Environment env;

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

    @Test
    public void testApiKey() {
        String api_key = env.getProperty("themoviedb.org.api_key");
        System.out.println(api_key);
        assertEquals("f353d9c7a480afbfe32922d75a19d89b", api_key, "Check if API is still the same");

    }




    @Autowired
    private ApplicationContext context;

    @Test
    public void testBean() {
//        List<String> movieGenres = (List<String>) context.getBean("testWithSingleton");
//
//        System.out.println(movieGenres);

    }

}
