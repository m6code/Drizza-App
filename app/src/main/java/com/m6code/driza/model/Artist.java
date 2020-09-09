package com.m6code.driza.model;

public class Artist {
    private String id;
    private String name;
    private String link;
    private String picture_medium;
    private String nb_album;
    private String trackListUrl;
    private String type;

    public Artist() {

    }

    public String getDetails() {
        return type + " (" + nb_album + ") Albums";
    }
}
