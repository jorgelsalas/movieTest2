package asynctasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.demo.rte.movietest2.VideoActivity;
import com.demo.rte.movietest2.VideoActivity2;

import java.io.IOException;

import api.MovieService;
import constants.APIConstants;
import entities.VideosResponse;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by jorge on 9/6/15.
 */
public class VideoQueryTask2 extends AsyncTask<String, Integer, String> {

    private Context mContext;
    private VideosResponse videosResponse = null;
    private String id;

    public VideoQueryTask2(){

    }

    public VideoQueryTask2(Context context, String id){
        this.mContext = context;
        this.id = id;
        Log.e("MOVIE ID FROM TASK:", id);
    }


    @Override
    protected String doInBackground(String... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(APIConstants.BASE_URL)
                .build();
        MovieService service = retrofit.create(MovieService.class);
        //ArrayList<Movie> movies = service.discoverMovies(APIConstants.API_KEY);
        //Log.e("",movies.toString());
        Call<VideosResponse> call = service.getMovieVideos(id, APIConstants.API_KEY);
        //response.toString();
        try {
            Response response =  call.execute();
            Log.e("Message: ", response.message());
            if(null != response.errorBody()) Log.e("error body string: ", response.errorBody().string());
            if(null != response.errorBody()) Log.e("error body to string:", response.errorBody().toString());

            Log.e("response to string:", response.toString());
            //Log.e("body to string:", response.body().toString());
            Log.e("Code:", "" + response.code());
            Log.e("Headers to string:", response.headers().toString());
            Log.e("isSuccess to string:", "" + response.isSuccess());
            Log.e("raw:", "" + response.raw());
            Log.e("raw to string:", "" + response.raw().toString());
            Log.e("response to string:", response.toString());

            videosResponse = (VideosResponse) response.body();
            //String st = videosResponse.getResults().toString();
            //Log.e("APIRESPONSE RESULTS",st);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    protected void onPostExecute(String result) {
        if(videosResponse.getResults() != null){
            String key = videosResponse.getResults().get(0).getKey();
            ((VideoActivity2) mContext).setNewVideo(key);
        }

    }
    public void logIt(String st){
        Log.e("",st);
    }
}
