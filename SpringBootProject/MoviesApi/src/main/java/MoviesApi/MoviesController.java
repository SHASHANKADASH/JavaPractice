package MoviesApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MoviesController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("/movies")
    public List<Movie> getMovies(){
        return movieService.getMovies();
    }

    @RequestMapping("/movies/{rating}")
    public List<Movie> getMovieByRating(@PathVariable String rating){
        return movieService.getMovieByRating(rating);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/movies/{name}",produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String getMovieByName(@PathVariable String name){
        Movie k = movieService.getMovieByName(name);
        return "<html>" + "<header><title>Movie</title></header>\n" +
                "<body>\n" + "<b>"+k.getName()+"</b>" + "</body>\n" + "</html>";
    }

    @RequestMapping(method = RequestMethod.POST,value = "/movies")
    public Movie addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/movies/{name}")
    public Movie updateMovie(@RequestBody Movie movie, @PathVariable String name){

        return movieService.updateMovie(movie,name);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/movies/{name}")
    public Movie deleteMovieByName(@PathVariable String name){
        return movieService.deleteMovieByName(name);
    }



}
