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

    private Comparator<TheMarvelUniverseDTO> comparator;

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
        // Sorting using the Collections API
        Comparator<TheMarvelUniverseDTO> comparator = Comparator.comparing(TheMarvelUniverseDTO::getOriginalTitle);
        theMarvelUniverseDTOList.sort(comparator);
        return theMarvelUniverseDTOList;
    }

    public List<TheMarvelUniverseDTO> listTheMarvelUniverseByTitle(String sortingOrder) {
        // Sorting using the stream API
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

    public List<TheMarvelUniverseDTO> listTheMarvelUniverseByPopularity(String sortingOrder) {
        if (sortingOrder.equals("ascending")) {
            comparator = Comparator.comparing(TheMarvelUniverseDTO::getPopularity);
        } else {
            comparator = Comparator.comparing(TheMarvelUniverseDTO::getPopularity).reversed();
        }

        theMarvelUniverseDTOList.sort(comparator);
        return theMarvelUniverseDTOList;
    }

    public List<TheMarvelUniverseDTO> listTheMarvelUniverseByReleaseDate(String sortingOrder) {
        if (sortingOrder.equals("ascending")) {
            comparator = Comparator.comparing(TheMarvelUniverseDTO::getReleaseDate);
        } else {
            comparator = Comparator.comparing(TheMarvelUniverseDTO::getReleaseDate).reversed();
        }

        theMarvelUniverseDTOList.sort(comparator);
        return theMarvelUniverseDTOList;
    }

    public List<TheMarvelUniverseDTO> listTheMarvelUniverseByVoteAverage(String sortingOrder) {
        if (sortingOrder.equals("ascending")) {
            comparator = Comparator.comparing(TheMarvelUniverseDTO::getVoteAverage);
        } else {
            comparator = Comparator.comparing(TheMarvelUniverseDTO::getVoteAverage).reversed();
        }

        theMarvelUniverseDTOList.sort(comparator);
        return theMarvelUniverseDTOList;
    }

    public List<TheMarvelUniverseDTO> listTheMarvelUniverseByVoteCount(String sortingOrder) {
        if (sortingOrder.equals("ascending")) {
            comparator = Comparator.comparing(TheMarvelUniverseDTO::getVoteCount);
        } else {
            comparator = Comparator.comparing(TheMarvelUniverseDTO::getVoteCount).reversed();
        }

        theMarvelUniverseDTOList.sort(comparator);
        return theMarvelUniverseDTOList;
    }

}
