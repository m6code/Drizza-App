package com.m6code.driza.datasource;

import android.content.SearchRecentSuggestionsProvider;

public class SearchSuggestionProvider extends SearchRecentSuggestionsProvider {
    public final static String AUTHORITY = "com.m6code.driza.datasource.SearchSuggestionProvider";
    public final static int MODE = DATABASE_MODE_QUERIES;
    //public final static int MODE = DATABASE_MODE_QUERIES | DATABASE_MODE_2LINES; // if you want to provide 2 line in each suggestion

    public SearchSuggestionProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }

}
