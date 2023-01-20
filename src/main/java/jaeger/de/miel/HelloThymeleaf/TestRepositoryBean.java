package jaeger.de.miel.HelloThymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Scope("singleton")
public class TestRepositoryBean {

    @Autowired
    TheMovieDBDelegate theMovieDBDelegate;

    public List<String> getGenres() {

        return theMovieDBDelegate.listMovieGenres();
    }

}
