package api;

import entities.APIResponse;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by jorge on 9/6/15.
 */
public interface MovieService {

    //@GET("discover/movie")
    //ArrayList<Movie> discoverMovies(@Query("api_key")String api_key);

    @GET("discover/movie")
    Call<APIResponse> discoverMovies(@Query("api_key")String api_key);
}
