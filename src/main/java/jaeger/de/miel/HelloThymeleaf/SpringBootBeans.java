package jaeger.de.miel.HelloThymeleaf;

import jaeger.de.miel.HelloThymeleaf.mappers.TheMarvelUniverseMapper;
import jaeger.de.miel.HelloThymeleaf.model.dto.TheMarvelUniverseDTO;
import jaeger.de.miel.HelloThymeleaf.model.org.themoviedb.lists.getdetails.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class SpringBootBeans {

    @Autowired
    private TheMovieDBService theMovieDBService;

    @Bean
//    @Scope("singleton")  // Default scope for a Bean is Singleton
    public List<TheMarvelUniverseDTO> getTheMarveUniverseObjListSingleton() {
        List<Item> theMarvelUniverseItems = theMovieDBService.listTheMarvelUniverse().block().getItems();

        List<TheMarvelUniverseDTO> result = theMarvelUniverseItems.stream()
                .map(item -> TheMarvelUniverseMapper.toDTO(item))
                .collect(Collectors.toList());

        return result;
    }
}
