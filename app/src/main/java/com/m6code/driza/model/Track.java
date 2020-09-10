package com.m6code.driza.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Track {

    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("link")
    private String link;

    @SerializedName("duration")
    private String duration;

    @SerializedName("track_position")
    private String trackPos;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("preview")
    private String previewUrl;

    @SerializedName("artist")
    private ArrayList<ArtistFromTrackSearch> mArtists = new ArrayList<>();

    private String artist; // artist.name

    @SerializedName("album")
    private ArrayList<AlbumFromTrackSearch> mAlbums = new ArrayList<>();

    private String album; // album.title

    @SerializedName("type")
    private String type;

    public Track(String title, String duration, String releaseDate, String type) {
        this.title = title;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.type = type;
    }

    public String getDetails() {
        return type + " - " + releaseDate;
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
