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

    public Track(String title, String duration, String trackPos, String releaseDate, String artist, String album, String type) {
        this.title = title;
        this.duration = duration;
        this.trackPos = trackPos;
        this.releaseDate = releaseDate;
        this.artist = artist;
        this.album = album;
        this.type = type;
    }

    public String getDetails() {
        return type + " Released: " + releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTrackPos() {
        return trackPos;
    }

    public void setTrackPos(String trackPos) {
        this.trackPos = trackPos;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
