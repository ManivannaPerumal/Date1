package com.example.devmachine_1.date1;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.devmachine_1.date1.searchview.MoviesAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Search extends AppCompatActivity implements MoviesAdapter.MoviesAdapterListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView rvItems;
    private List<String> movies;
    private MoviesAdapter adapter;
    private SearchView searchView;
    String [] s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        SearchView svMovies = findViewById(R.id.svMovies);

        rvItems = findViewById(R.id.rvItems);

        Context context =getApplicationContext();
        assert context != null;
         s =context.getResources().getStringArray(R.array.age);



        movies = new ArrayList<>();
        movies = Arrays.asList(s);

        adapter = new MoviesAdapter(this, movies, this);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext());
        rvItems.setLayoutManager(lm);
        rvItems.setItemAnimator(new DefaultItemAnimator());
        rvItems.setAdapter(adapter);

        svMovies.setActivated(true);
        svMovies.setQueryHint("Type your keyword here");
        svMovies.onActionViewExpanded();
        svMovies.setIconified(false);
        svMovies.clearFocus();

        svMovies.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        // close search view on back button pressed
        if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onSelected(String item) {

        Intent intent=new Intent();
        intent.putExtra("MESSAGE",item);
        setResult(2,intent);
        finish();//finishing activity
        Toast.makeText(this, "Selected: " + item, Toast.LENGTH_LONG).show();

    }
}
