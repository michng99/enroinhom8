package com.freesongs.musikplayer8.Music;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;

import com.freesongs.musikplayer8.Adapter.AdapterListBXH;
import com.freesongs.musikplayer8.Adapter.AdapterSearch;
import com.freesongs.musikplayer8.DAO.DaoBXH;
import com.freesongs.musikplayer8.Model.Songs;
import com.freesongs.musikplayer8.R;

import java.util.ArrayList;

public class Search extends AppCompatActivity {
    RecyclerView rcsearch;
    Toolbar toolbarr ;
    private SearchView searchView ;
    AdapterSearch adapterSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        rcsearch = findViewById(R.id.rcsearch);
        toolbarr = findViewById(R.id.toolbarr);
        setSupportActionBar(toolbarr);

        rcsearch = findViewById(R.id.rcsearch);
        DaoBXH daoBXH = new DaoBXH(this);
        ArrayList<Songs> list = daoBXH.getBXH();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcsearch.setLayoutManager(linearLayoutManager);
        adapterSearch = new AdapterSearch(this,list);
        rcsearch.setAdapter(adapterSearch);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rcsearch.addItemDecoration(itemDecoration);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search , menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapterSearch.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterSearch.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }

}