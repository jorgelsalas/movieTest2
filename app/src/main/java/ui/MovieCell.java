package ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.demo.rte.movietest2.R;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import constants.APIConstants;
import entities.Movie;


/**
 * Created by jorge on 9/6/15.
 */
public class MovieCell extends RelativeLayout {
    private Movie movie;
    private ImageView moviePoster;
    private TextView movieTitle;
    private TextView movieDescription;

    public MovieCell(Context context) {
        super(context);
    }

    public MovieCell(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MovieCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();
        this.movieDescription = (TextView) this.findViewById(R.id.description);
        this.movieTitle = (TextView) this.findViewById(R.id.title);
        this.moviePoster = (ImageView) this.findViewById(R.id.moviePoster);
    }

    public void setModel(Movie movie){
        this.movie = movie;
        updateUI();
    }

    private void updateUI(){
        this.movieTitle.setText(movie.getTitle());
        this.movieDescription.setText(movie.getOverview());
        String imageURL = APIConstants.IMAGE_BASE_URL + APIConstants.IMAGE_SIZE_300_URL + movie.getPoster_path();
        Log.e("IMAGE URL", imageURL);


        Picasso.with(getContext()).load(APIConstants.IMAGE_BASE_URL + APIConstants.IMAGE_SIZE_150_URL + movie.getPoster_path()).into(moviePoster);
    }
}
