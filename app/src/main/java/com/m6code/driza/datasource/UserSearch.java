package com.m6code.driza.datasource;

public class UserSearch {
    private static String searchText = "";

    public static String getSearchText() {
        return searchText;
    }

    public static void setSearchText(String searchText) {
        UserSearch.searchText = searchText;
    }
}
