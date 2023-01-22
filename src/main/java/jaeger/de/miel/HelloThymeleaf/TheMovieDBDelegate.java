package jaeger.de.miel.HelloThymeleaf;

import jaeger.de.miel.HelloThymeleaf.mappers.TheMarvelUniverseMapper;
import jaeger.de.miel.HelloThymeleaf.model.entities.TheMarvelUniverseObj;
import jaeger.de.miel.HelloThymeleaf.model.org.themoviedb.genre.movie.Genre;
import jaeger.de.miel.HelloThymeleaf.model.org.themoviedb.lists.getdetails.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheMovieDBDelegate {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private TheMovieDBService theMovieDBService;

//    Put this code in a @PostConstruct method
//    private List<TheMarvelUniverseObj>  theMarvelUniverseObjList = (List<TheMarvelUniverseObj>) context.getBean("getTheMarveUniverseObjListSingleton");

    public List<String> listMovieGenres() {
        List<Genre> movieGenres = theMovieDBService.listMovieGenres().block().getGenres();

        List<String> result = movieGenres.stream()
                .map(genre -> genre.getName())
                .collect(Collectors.toList());

        return result;
    }

    public List<TheMarvelUniverseObj> listTheMarvelUniverse() {
        var result = (List<TheMarvelUniverseObj>) context.getBean("getTheMarveUniverseObjListSingleton");
        result.sort((obj1, obj2) -> obj1.getOriginalTitle().compareTo(obj2.getOriginalTitle()));
        return result;
//        theMarvelUniverseObjList.sort((obj1, obj2) -> obj1.getOriginalTitle().compareTo(obj2.getOriginalTitle()));
//        return theMarvelUniverseObjList;
    }

}
