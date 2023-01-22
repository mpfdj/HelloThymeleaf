package jaeger.de.miel.HelloThymeleaf.mappers;

import jaeger.de.miel.HelloThymeleaf.model.entities.TheMarvelUniverseObj;
import jaeger.de.miel.HelloThymeleaf.model.org.themoviedb.lists.getdetails.Item;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

@Component
public class TheMarvelUniverseMapper {

    public static TheMarvelUniverseObj toObj(Item theMarvelUniverseItem) {
        LocalDate releaseDate = LocalDate.parse(theMarvelUniverseItem.getReleaseDate(), ISO_LOCAL_DATE);

        var theMarvelUniverseObj = new TheMarvelUniverseObj();
        theMarvelUniverseObj.setOriginalTitle(theMarvelUniverseItem.getOriginalTitle());
        theMarvelUniverseObj.setPopularity(theMarvelUniverseItem.getPopularity());
        theMarvelUniverseObj.setPosterPath(theMarvelUniverseItem.getPosterPath());
        theMarvelUniverseObj.setReleaseDate(releaseDate);
        theMarvelUniverseObj.setVoteAverage(theMarvelUniverseItem.getVoteAverage());
        theMarvelUniverseObj.setVoteCount(theMarvelUniverseItem.getVoteCount());
        return theMarvelUniverseObj;
    }
}
