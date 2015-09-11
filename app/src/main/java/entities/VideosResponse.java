package entities;

import java.util.ArrayList;

/**
 * Created by Jorge on 10/09/2015.
 */
public class VideosResponse {
    String id;
    ArrayList<Video> results;

    public VideosResponse(String id, ArrayList<Video> videos) {
        this.id = id;
        this.results = videos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Video> getResults() {
        return results;
    }

    public void setResults(ArrayList<Video> results) {
        this.results = results;
    }
}
