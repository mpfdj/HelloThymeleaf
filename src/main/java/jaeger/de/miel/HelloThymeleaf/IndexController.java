package jaeger.de.miel.HelloThymeleaf;

import com.binaryheart.common.comparator.AlphaNumericComparator;
import jaeger.de.miel.HelloThymeleaf.dto.ContentItemDTO;
import jaeger.de.miel.HelloThymeleaf.model.dto.MovieDTO;
import jaeger.de.miel.HelloThymeleaf.model.dto.TheMarvelUniverseDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private TheMovieDBDelegate theMovieDBDelegate;

    @Autowired
    private ApplicationContext context;

    private List<ContentItemDTO> contentItemDTOs;

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

    @GetMapping("test-with-sort")
    public String testWithSort(Model model) throws IOException {

        AlphaNumericComparator comparator = new AlphaNumericComparator();
        Comparator<ContentItemDTO> compareByNameAsc = (dto1, dto2) -> comparator.compare(dto1.getName(), dto2.getName());
        Comparator<ContentItemDTO> compareByNameDesc = (dto1, dto2) -> comparator.compare(dto2.getName(), dto1.getName());
        model.addAttribute("contentItemDTOs", contentItemDTOs);
        model.addAttribute("compareByNameAsc", compareByNameAsc);
        model.addAttribute("compareByNameDesc", compareByNameDesc);

        return "test-with-sort";
    }


    @GetMapping("test-with-layout")
    public String testWithLayout(Model model) {
        List<String> pcodes = List.of("P00001","P00002","P00003","P00004","P00005","P00006","P00007","P00008","P00009","P00010","P00011","P00012","P00013","P00014","P00015","P00029","P00030","P00031","P00032","P00033","P00034","P00035","P00036","P00037","P00038","P00039","P00040","P00041","P00042","P00043","P00044","P00045","P00046","P00047","P00048","P00049","P00050");
        model.addAttribute("pcodes", pcodes);
        return "test-with-layout";
    }


    @GetMapping("get-data")
    public String get(@RequestParam(value = "pcode") String pcode, Model model) {
//        System.out.println("get-data for pcode:" + pcode);
//        return "test-with-layout :: #main";

//        model.addAttribute("numDeviceEventsWithAlarm", 100);

        // change "myview" to the name of your view
        return "test-with-layout :: #main";



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

    @PostConstruct
    public void postConstruct() {
        contentItemDTOs = (List<ContentItemDTO>) context.getBean("getContentItemDTOs");
    }











}
