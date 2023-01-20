package jaeger.de.miel.HelloThymeleaf;

import jaeger.de.miel.HelloThymeleaf.model.org.themoviedb.genre.movie.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Configuration
public class MyConfig {


    @Autowired
    private TheMovieDBDelegate movieDBDelegate;


    @Bean
    @Scope("singleton")
    public List<String> testWithSingleton() {
//        Genre genre = new Genre();
//        genre.setId(1);
//        genre.setName("some genre");
        System.out.println("calling testWithSingleton...");

        return movieDBDelegate.listMovieGenres();
//        return List.of("aaa", "bbb", "ccc");
    }
}
