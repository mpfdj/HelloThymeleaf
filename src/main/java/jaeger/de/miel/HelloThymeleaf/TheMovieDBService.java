package jaeger.de.miel.HelloThymeleaf;

import jaeger.de.miel.HelloThymeleaf.model.org.themoviedb.genre.movie.GenresResponse;
import jaeger.de.miel.HelloThymeleaf.model.org.themoviedb.lists.getdetails.ListResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TheMovieDBService {

    private final WebClient webClient;

    @Autowired
    private Environment env;

    private String api_key;


    public TheMovieDBService() {
        WebClient.Builder builder = WebClient.builder();
        this.webClient = builder.baseUrl("https://api.themoviedb.org/3").build();
    }

    public Mono<GenresResponse> listMovieGenres() {
        System.out.println("calling listMovieGenres WebClient....");
        return this.webClient
                .get()
                .uri("/genre/movie/list?api_key=" + api_key)
                .retrieve().bodyToMono(GenresResponse.class);

//        With logging
//        return this.webClient
//                .get()
//                .uri("/genre/movie/list?api_key=" + api_key)
//                .retrieve().bodyToMono(GenresResponse.class)
//                .log();
    }

    public Mono<ListResponse> listTheMarvelUniverse() {
        System.out.println("calling listTheMarvelUniverse WebClient");
        return this.webClient
                .get()
                .uri("/list/1?api_key=" + api_key)
                .retrieve().bodyToMono(ListResponse.class);
    }

    @PostConstruct
    public void postConstruct() {
        api_key = env.getProperty("themoviedb.org.api_key");
    }

}