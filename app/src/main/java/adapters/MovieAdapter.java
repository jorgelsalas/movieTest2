package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

//import com.example.jorge.movies.R;

import com.demo.rte.movietest2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import entities.Movie;
import ui.MovieCell;

/**
 * Created by jorge on 9/6/15. Movie adapter
 *
 */
public class MovieAdapter extends BaseAdapter {

    private ArrayList<Movie> movies = new ArrayList<>();
    private Context mContext;


    public MovieAdapter(ArrayList<Movie> newMovies, Context newContext){
        this.movies = newMovies;
        this.mContext = newContext;
    }

    public MovieAdapter(Context newContext){
        this.mContext = newContext;
        setDummyContent();
    }

    public MovieAdapter(){
        setDummyContent();
    }

    private void setDummyContent(){
        ArrayList<Movie> newMovies = new ArrayList<>();
        this.movies = newMovies;
        movies.add(new Movie("peli1", "Desc peli1"));
        movies.add(new Movie("peli2", "Desc peli2"));
        movies.add(new Movie("peli3", "Desc peli3"));
        movies.add(new Movie("peli4", "Desc peli4"));
        movies.add(new Movie("peli5", "Desc peli5"));
    }

    public void setNewMovies(ArrayList<Movie> newMovies){
        this.movies = newMovies;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MovieCell v = (MovieCell) convertView;
        if(null == convertView){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = (MovieCell) inflater.inflate(R.layout.movie_cell, null);
        }
        //Movie mov = new Movie(movies.get(position).getTitle(), movies.get(position).getOverview());
        Movie mov = movies.get(position);
        //Picasso.with(mContext).load("").into();
        v.setModel(mov);
        return v;
    }
}
