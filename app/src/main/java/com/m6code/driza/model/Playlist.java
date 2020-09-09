package com.m6code.driza.model;

import java.util.ArrayList;

public class Playlist {
    private String id;
    private String title;
    private String duration;
    private String nb_tracks;
    private String link;
    private String pictureMed;
    private String trackListUrl;
    private String creationDate;
    private String creator; // creator.name
    private String type;
    private ArrayList<Track> trackList; // tracks.data

    public Playlist() {
    }

    public String getDetails() {
        return type + " (" + nb_tracks + ") tracks " + " duration " + duration
                + "by " + creator + " created: " + creationDate;
    }
}
