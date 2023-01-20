package jaeger.de.miel.HelloThymeleaf;

import jaeger.de.miel.HelloThymeleaf.model.org.themoviedb.genre.movie.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheMovieDBDelegate {

    @Autowired
    private TheMovieDBService theMovieDBService;

    public List<String> listMovieGenres() {
        List<Genre> movieGenres = theMovieDBService.listMovieGenres().block().getGenres();

        List<String> result = movieGenres.stream()
                .map(genre -> genre.getName())
                .collect(Collectors.toList());

        return result;
    }

}
