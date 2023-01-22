package jaeger.de.miel.HelloThymeleaf;

import jaeger.de.miel.HelloThymeleaf.model.entities.TheMarvelUniverseObj;
import jaeger.de.miel.HelloThymeleaf.model.org.themoviedb.lists.getdetails.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = SpringBootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TheMovieDBDelegateTest {

    @Autowired
    private TheMovieDBDelegate movieDBDelegate;

    @Test
    void listTheMarvelUniverse() {
        List<TheMarvelUniverseObj> listTheMarvelUniverse = movieDBDelegate.listTheMarvelUniverseByTitle();
        System.out.println(listTheMarvelUniverse);
    }

    @Test
    public void testWithLocalDate() {
        String release_date = "2021-12-15";
        LocalDate releaseDate = LocalDate.parse(release_date, ISO_LOCAL_DATE);
        System.out.println(releaseDate.toString());
    }
}