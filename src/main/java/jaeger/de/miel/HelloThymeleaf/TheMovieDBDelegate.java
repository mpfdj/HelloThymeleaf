package jaeger.de.miel.HelloThymeleaf;

import jaeger.de.miel.HelloThymeleaf.model.dto.TheMarvelUniverseDTO;
import jaeger.de.miel.HelloThymeleaf.model.org.themoviedb.genre.movie.Genre;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheMovieDBDelegate {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private TheMovieDBService theMovieDBService;

    private List<TheMarvelUniverseDTO> theMarvelUniverseDTOList;


    @PostConstruct
    public void postConstruct() {
        theMarvelUniverseDTOList = (List<TheMarvelUniverseDTO>) context.getBean("getTheMarveUniverseObjListSingleton");
    }

    public List<String> listMovieGenres() {
        List<Genre> movieGenres = theMovieDBService.listMovieGenres().block().getGenres();

        List<String> result = movieGenres.stream()
                .map(genre -> genre.getName())
                .collect(Collectors.toList());

        return result;
    }

    public List<TheMarvelUniverseDTO> listTheMarvelUniverseByTitle() {
        // Sorting on a Collections API
        theMarvelUniverseDTOList.sort((obj1, obj2) -> obj1.getOriginalTitle().compareTo(obj2.getOriginalTitle()));
        return theMarvelUniverseDTOList;
    }

    public List<TheMarvelUniverseDTO> listTheMarvelUniverseByTitle(String sortingOrder) {
        Comparator<TheMarvelUniverseDTO> comparator;
        if (sortingOrder.equals("ascending")) {
            comparator = Comparator.comparing(TheMarvelUniverseDTO::getOriginalTitle);
        } else {
            comparator = Comparator.comparing(TheMarvelUniverseDTO::getOriginalTitle).reversed();
        }

        List<TheMarvelUniverseDTO> result = theMarvelUniverseDTOList.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        return result;
    }

    public List<TheMarvelUniverseDTO> listTheMarvelUniverseByPopularity() {
        // Sorting using stream API
        List<TheMarvelUniverseDTO> result = theMarvelUniverseDTOList.stream()
                .sorted(Comparator.comparing(TheMarvelUniverseDTO::getPopularity).reversed())
                .collect(Collectors.toList());
        return result;

//        theMarvelUniverseDTOList.sort((obj1, obj2) -> obj2.getPopularity().compareTo(obj1.getPopularity()));
//        return theMarvelUniverseDTOList;
    }

    public List<TheMarvelUniverseDTO> listTheMarvelUniverseByReleaseDate() {
        List<TheMarvelUniverseDTO> result = theMarvelUniverseDTOList.stream()
                .sorted(Comparator.comparing(TheMarvelUniverseDTO::getReleaseDate).reversed())
                .collect(Collectors.toList());
        return result;
    }

    public List<TheMarvelUniverseDTO> listTheMarvelUniverseByVoteAverage() {
        List<TheMarvelUniverseDTO> result = theMarvelUniverseDTOList.stream()
                .sorted(Comparator.comparing(TheMarvelUniverseDTO::getVoteAverage).reversed())
                .collect(Collectors.toList());
        return result;
    }

    public List<TheMarvelUniverseDTO> listTheMarvelUniverseByVoteCount() {
        List<TheMarvelUniverseDTO> result = theMarvelUniverseDTOList.stream()
                .sorted(Comparator.comparing(TheMarvelUniverseDTO::getVoteCount).reversed())
                .collect(Collectors.toList());
        return result;
    }

}
