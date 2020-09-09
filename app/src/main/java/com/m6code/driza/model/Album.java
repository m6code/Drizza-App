package com.m6code.driza.model;

import java.util.ArrayList;

public class Album {

    private String id;
    private String title;
    private String link;
    private String coverMedium;
    private String nbTracks;
    private String duration;
    private String trackListUrl;
    private ArrayList<Track> trackList;
    private String artist;
    private String recordType;
    private String type;
    private String releaseDate;

    public Album() {
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getCoverMedium() {
        return coverMedium;
    }

    public String getNbTracks() {
        return nbTracks;
    }

    public ArrayList<Track> getTrackList() {
        return trackList;
    }

    public String getArtist() {
        return artist;
    }

    public String getDetails() {
        return type + " (" + nbTracks + ")" + " - Duration " + duration + " Released: " + releaseDate;
    }

}
