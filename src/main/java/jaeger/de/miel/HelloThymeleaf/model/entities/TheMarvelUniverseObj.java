package jaeger.de.miel.HelloThymeleaf.model.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class TheMarvelUniverseObj {
    private String originalTitle;
    private float popularity;
    private String posterPath;
    private LocalDate releaseDate;
    private int voteAverage;
    private int voteCount;
}
