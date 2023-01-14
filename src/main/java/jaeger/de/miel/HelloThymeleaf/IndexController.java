package jaeger.de.miel.HelloThymeleaf;

import jaeger.de.miel.HelloThymeleaf.model.entities.MovieObj;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

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
    public String listTheMarvelUniverseGet(Model model) {
        return "list-the-marvel-universe";
    }

    @GetMapping("list-movie-genres")
    public String listMovieGenres(Model model) {
        return "list-movie-genres";
    }





    @PostMapping("findMovie")
    public String findMoviePost(@ModelAttribute MovieObj movieObj, Model model) {
        System.out.println("calling findMovie");
        System.out.println(movieObj);
        model.addAttribute("title", movieObj.getTitle());

        return "find-movie";
    }

    @PostMapping("listMovieGenres")
    public String listMovieGenresPost(Model model) {
        System.out.println("calling listMovieGenres");
        return "list-movie-genres";
    }

    @PostMapping("listMarvelUniverse")
    public String listTheMarvelUniverse(Model model) {
        System.out.println("calling listMarvelUniverse");
        return "list-the-marvel-universe";
    }

}
