
package jaeger.de.miel.HelloThymeleaf.model.org.themoviedb.genre.movie;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "genres"
})
@Generated("jsonschema2pojo")
public class GenresResponse {

    @JsonProperty("genres")
    private List<Genre> genres = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenresResponse() {
    }

    /**
     * 
     * @param genres
     */
    public GenresResponse(List<Genre> genres) {
        super();
        this.genres = genres;
    }

    @JsonProperty("genres")
    public List<Genre> getGenres() {
        return genres;
    }

    @JsonProperty("genres")
    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

}
