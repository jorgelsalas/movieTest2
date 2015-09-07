package com.demo.rte.movietest2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import adapters.MovieAdapter;
import asynctasks.movieQueryTask;
import entities.Movie;


public class MainActivity extends ActionBarActivity {

    //TODO: Improve rest client adding api key in every call with interceptor
    private ListView movieList;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieList = (ListView) findViewById(R.id.movie_list);
        movieAdapter = new MovieAdapter(this);
        movieList.setAdapter(movieAdapter);
        new movieQueryTask(this).execute("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setNewMovies(ArrayList<Movie> newMovies){
        movieAdapter.setNewMovies(newMovies);
    }
}
