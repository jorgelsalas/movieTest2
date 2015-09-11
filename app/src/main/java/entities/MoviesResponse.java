package entities;

import java.util.ArrayList;

/**
 * Created by jorge on 9/6/15.
 */
public class MoviesResponse {

    long page;
    ArrayList<Movie> results;

    public MoviesResponse(long page, ArrayList<Movie> results) {
        this.page = page;
        this.results = results;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public ArrayList<Movie> getResults() {
        return results;
    }

    public void setResults(ArrayList<Movie> results) {
        this.results = results;
    }
}
