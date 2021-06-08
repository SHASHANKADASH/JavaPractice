package MoviesApi;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    public List<Movie> movies = new ArrayList<Movie>(Arrays.asList(
            new Movie("Avengers","8.5","Russo Brothers"),
            new Movie("Sherlock Holmes","9.0","Guy Ritchie"),
            new Movie("Lord of the Rings","8.8","Peter Jackson"),
            new Movie("Interstellar","8.7","Christopher Nolan"),
            new Movie("Avengers Infinity War","8.5","Russo Brothers"),
            new Movie("Mission Impossible","8.5","Someone")
    ));

    public List<Movie> getMovies(){
        return movies;
    }

    public List<Movie> getMovieByRating(String rating){
        return movies.stream().filter(x-> x.getRating().equals(rating)).collect(Collectors.toList());
    }

    public Movie addMovie(Movie movie){
        movies.add(movie);
        return movie;
    }

    public  Movie getMovieByName(String name){
        for(int i=0;i<movies.size();i++)
        {System.out.println(movies.get(i));
            if(movies.get(i).getName().equals(name))
            {
                System.out.println(movies.get(i));
                return movies.get(i);
            }
        }
        return null;
    }

    public Movie updateMovie(Movie movie, String name)
    {
        for(int i=0;i<movies.size();i++)
        {
            if(movies.get(i).getName().equals(name))
            {
                movies.set(i,movie);
            }
        }
        return movie;
    }

    public Movie deleteMovieByName(String name){
        for(int i=0;i<movies.size();i++)
        {
            if(movies.get(i).getName().equals(name))
            {
                return movies.remove(i);
            }
        }
        return null;
    }





}
