package com.m6code.driza;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.m6code.driza.ui.track.TrackViewModel;

public class SearchResultsActivity extends Activity {

    private static String query = "Enemies";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        ActionBar actionBar = getActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(false);

        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            query = intent.getStringExtra(SearchManager.QUERY);
            //use the query to search your data somehow
            Log.i("LogEnteredText: ", query);
            setQuery(query);
//            Intent searchIntent = new Intent(this, TrackViewModel.class);
//            searchIntent.putExtra("query", query);
        }
    }

    public static String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        SearchResultsActivity.query = query;
    }

}