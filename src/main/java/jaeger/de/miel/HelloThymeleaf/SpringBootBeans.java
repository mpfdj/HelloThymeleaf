package jaeger.de.miel.HelloThymeleaf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import jaeger.de.miel.HelloThymeleaf.dto.ContentItemDTO;
import jaeger.de.miel.HelloThymeleaf.mappers.TheMarvelUniverseMapper;
import jaeger.de.miel.HelloThymeleaf.model.dto.TheMarvelUniverseDTO;
import jaeger.de.miel.HelloThymeleaf.model.org.themoviedb.lists.getdetails.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
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

    @Bean
    public List<ContentItemDTO> getContentItemDTOs() throws IOException {
        File jsonFile = ResourceUtils.getFile("classpath:data.json");
        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
        CollectionType objectMapperClass = objectMapper.getTypeFactory().constructCollectionType(List.class, ContentItemDTO.class);
        return objectMapper.readValue(jsonFile, objectMapperClass);
    }

}
