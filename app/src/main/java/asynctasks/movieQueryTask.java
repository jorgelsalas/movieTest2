package asynctasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.demo.rte.movietest2.MainActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.transform.Result;

import api.MovieService;
import constants.APIConstants;
import entities.APIResponse;
import entities.Movie;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by jorge on 9/6/15.
 */
public class movieQueryTask extends AsyncTask<String, Integer, String> {

    private Context mContext;
    private APIResponse moviesResponse = null;

    public movieQueryTask(){

    }

    public movieQueryTask(Context context){
        this.mContext = context;

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
        Call<APIResponse> call = service.discoverMovies(APIConstants.API_KEY);
        //response.toString();
        try {
            Response response =  call.execute();
            Log.e("Message: ", response.message());
            if(null != response.errorBody()) Log.e("error body string: ", response.errorBody().string());
            if(null != response.errorBody()) Log.e("error body to string:", response.errorBody().toString());

            Log.e("response to string:", response.toString());
            Log.e("body to string:", response.body().toString());
            Log.e("Code:", "" + response.code());
            Log.e("Headers to string:", response.headers().toString());
            Log.e("isSuccess to string:", "" + response.isSuccess());
            Log.e("raw:", "" + response.raw());
            Log.e("raw to string:", "" + response.raw().toString());
            Log.e("response to string:", response.toString());

            moviesResponse = (APIResponse) response.body();
            String st = moviesResponse.getResults().toString();
            Log.e("APIRESPONSE RESULTS",st);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    protected void onPostExecute(String result) {
        ((MainActivity) mContext).setNewMovies(moviesResponse.getResults());
    }
    public void logIt(String st){
        Log.e("",st);
    }
}
