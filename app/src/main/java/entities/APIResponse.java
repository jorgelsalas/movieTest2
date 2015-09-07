package entities;

import java.util.ArrayList;

/**
 * Created by jorge on 9/6/15.
 */
public class APIResponse {

    long page;
    ArrayList<Movie2> results;

    public APIResponse(long page, ArrayList<Movie2> results) {
        this.page = page;
        this.results = results;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public ArrayList<Movie2> getResults() {
        return results;
    }

    public void setResults(ArrayList<Movie2> results) {
        this.results = results;
    }
}
