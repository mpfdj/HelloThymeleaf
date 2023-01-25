package jaeger.de.miel.HelloThymeleaf;

import jaeger.de.miel.HelloThymeleaf.model.dto.MovieDTO;
import jaeger.de.miel.HelloThymeleaf.model.dto.TheMarvelUniverseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private TheMovieDBDelegate theMovieDBDelegate;

    @Autowired
    private ApplicationContext context;

    @GetMapping

    public String index(Model model) {

        model.addAttribute("pageTitle", "Taming Thymeleaf");
        model.addAttribute("scientists", List.of("Albert Einstein",
                "Niels Bohr",
                "James Clerk Maxwell",
                "Miel"));
        return "index";
    }


    @GetMapping("find-movie")
    public String findMovie(Model model) {
        model.addAttribute("movieObj", null);
        return "find-movie";
    }

    @GetMapping("list-the-marvel-universe")
    public String listTheMarvelUniverseGet(
            @RequestParam(value = "action", defaultValue = "sort-by-title-asc") String action,
            Model model) {

        System.out.println("action is: " + action);

        List<TheMarvelUniverseDTO> theMarvelUniverse;

        switch (action) {
            case "sort-by-title-asc":
                theMarvelUniverse = theMovieDBDelegate.listTheMarvelUniverseByTitle("ascending");
                break;
            case "sort-by-title-desc":
                theMarvelUniverse = theMovieDBDelegate.listTheMarvelUniverseByTitle("descending");
                break;
            case "sort-by-popularity-asc":
                theMarvelUniverse = theMovieDBDelegate.listTheMarvelUniverseByPopularity("ascending");
                break;
            case "sort-by-popularity-desc":
                theMarvelUniverse = theMovieDBDelegate.listTheMarvelUniverseByPopularity("descending");
                break;
            case "sort-by-release-date-asc":
                theMarvelUniverse = theMovieDBDelegate.listTheMarvelUniverseByReleaseDate("ascending");
                break;
            case "sort-by-release-date-desc":
                theMarvelUniverse = theMovieDBDelegate.listTheMarvelUniverseByReleaseDate("descending");
                break;
            case "sort-by-vote-average-asc":
                theMarvelUniverse = theMovieDBDelegate.listTheMarvelUniverseByVoteAverage("ascending");
                break;
            case "sort-by-vote-average-desc":
                theMarvelUniverse = theMovieDBDelegate.listTheMarvelUniverseByVoteAverage("descending");
                break;
            case "sort-by-vote-count-asc":
                theMarvelUniverse = theMovieDBDelegate.listTheMarvelUniverseByVoteCount("ascending");
                break;
            case "sort-by-vote-count-desc":
                theMarvelUniverse = theMovieDBDelegate.listTheMarvelUniverseByVoteCount("descending");
                break;
            default:
                theMarvelUniverse = null;
        }

        model.addAttribute("theMarvelUniverse", theMarvelUniverse);
        model.addAttribute("action", action);
        return "list-the-marvel-universe";
    }

    @GetMapping("list-movie-genres")
    public String listMovieGenres(Model model) {
        return "list-movie-genres";
    }

    @PostMapping("findMovie")
    public String findMoviePost(@ModelAttribute MovieDTO movieDTO, Model model) {
        System.out.println("calling findMovie");
        System.out.println(movieDTO);
        model.addAttribute("title", movieDTO.getTitle());


        return "find-movie";
    }

    @PostMapping("listMovieGenres")
    public String listMovieGenresPost(Model model) {
        System.out.println("calling listMovieGenres");
//        model.addAttribute("movieGenres", movieDBDelegate.listMovieGenres());


        model.addAttribute("movieGenres", (List<String>) context.getBean("testWithSingleton"));
//


        return "list-movie-genres";
    }

    @PostMapping("listMarvelUniverse")
    public String listTheMarvelUniverse(Model model) {
        System.out.println("calling listMarvelUniverse");
        return "list-the-marvel-universe";
    }

}
