package com.m6code.driza.model;

public class Track {
    private String id;
    private String title;
    private String link;
    private String duration;
    private String trackPos;
    private String releaseDate;
    private String previewUrl;
    private String artist; // artist.name
    private String album; // album.title
    private String type;

    public Track() {
    }

    public String getDetails() {
        return type + " Released: " + releaseDate;
    }
}
