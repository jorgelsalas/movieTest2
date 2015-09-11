package api;

import entities.MoviesResponse;
import entities.VideosResponse;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by jorge on 9/6/15.
 */
public interface MovieService {

    //@GET("discover/movie")
    //ArrayList<Movie> discoverMovies(@Query("api_key")String api_key);

    @GET("discover/movie")
    Call<MoviesResponse> discoverMovies(@Query("api_key")String api_key);

    @GET("movie/{id}/videos")
    Call<VideosResponse> getMovieVideos(@Path("id")String id, @Query("api_key")String api_key);
}
