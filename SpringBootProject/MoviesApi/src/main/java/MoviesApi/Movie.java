package MoviesApi;

public class Movie {

    private String name;
    private String rating;
    private String director;

    public Movie(String name, String rating, String director) {
        this.name = name;
        this.rating = rating;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public String getRating() {
        return rating;
    }

    public String getDirector() {
        return director;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
