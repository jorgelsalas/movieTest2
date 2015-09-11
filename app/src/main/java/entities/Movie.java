package entities;

/**
 * Created by jorge on 9/6/15. Movie type
 */
public class Movie {

    String id;
    String original_title;
    String overview;
    String poster_path;
    String title;

    public Movie(String original_title, String overview, String poster_path, String title) {
        this.original_title = original_title;
        this.overview = overview;
        this.poster_path = poster_path;
        this.title = title;
    }



    public Movie(String original_title, String overview) {
        this.original_title = original_title;
        this.overview = overview;
    }

    public Movie(String original_title, String overview, String poster_path) {
        this.original_title = original_title;
        this.overview = overview;
        this.poster_path = poster_path;
    }

    public Movie(String id, String original_title, String overview, String poster_path, String title) {
        this.id = id;
        this.original_title = original_title;
        this.overview = overview;
        this.poster_path = poster_path;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
