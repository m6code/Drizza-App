package com.m6code.driza.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Album {

    @SerializedName("id")
    @Expose
    private BigInteger id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("cover")
    @Expose
    private String cover;
    @SerializedName("cover_small")
    @Expose
    private String coverSmall;
    @SerializedName("cover_medium")
    @Expose
    private String coverMedium;
    @SerializedName("cover_big")
    @Expose
    private String coverBig;
    @SerializedName("cover_xl")
    @Expose
    private String coverXl;
    @SerializedName("md5_image")
    @Expose
    private String md5Image;
    @SerializedName("tracklist")
    @Expose
    private String tracklist;
    @SerializedName("type")
    @Expose
    private String type;

    // Single Album search
    @SerializedName("upc")
    @Expose
    private String upc;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("share")
    @Expose
    private String share;
    @SerializedName("genre_id")
    @Expose
    private Integer genreId;
    @SerializedName("genres")
    @Expose
    private Genres genres;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("nb_tracks")
    @Expose
    private Integer nbTracks;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("fans")
    @Expose
    private BigInteger fans;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("record_type")
    @Expose
    private String recordType;
    @SerializedName("available")
    @Expose
    private Boolean available;
    @SerializedName("explicit_lyrics")
    @Expose
    private Boolean explicitLyrics;
    @SerializedName("explicit_content_lyrics")
    @Expose
    private Integer explicitContentLyrics;
    @SerializedName("explicit_content_cover")
    @Expose
    private Integer explicitContentCover;
    @SerializedName("contributors")
    @Expose
    private List<Contributor> contributors = null;
    @SerializedName("artist")
    @Expose
    private Artist artist;
    @SerializedName("tracks")
    @Expose
    private Tracks tracks;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCoverSmall() {
        return coverSmall;
    }

    public void setCoverSmall(String coverSmall) {
        this.coverSmall = coverSmall;
    }

    public String getCoverMedium() {
        return coverMedium;
    }

    public void setCoverMedium(String coverMedium) {
        this.coverMedium = coverMedium;
    }

    public String getCoverBig() {
        return coverBig;
    }

    public void setCoverBig(String coverBig) {
        this.coverBig = coverBig;
    }

    public String getCoverXl() {
        return coverXl;
    }

    public void setCoverXl(String coverXl) {
        this.coverXl = coverXl;
    }

    public String getMd5Image() {
        return md5Image;
    }

    public void setMd5Image(String md5Image) {
        this.md5Image = md5Image;
    }

    public String getTracklist() {
        return tracklist;
    }

    public void setTracklist(String tracklist) {
        this.tracklist = tracklist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    public Genres getGenres() {
        return genres;
    }

    public void setGenres(Genres genres) {
        this.genres = genres;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getNbTracks() {
        return nbTracks;
    }

    public void setNbTracks(Integer nbTracks) {
        this.nbTracks = nbTracks;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public BigInteger getFans() {
        return fans;
    }

    public void setFans(BigInteger fans) {
        this.fans = fans;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean getExplicitLyrics() {
        return explicitLyrics;
    }

    public void setExplicitLyrics(Boolean explicitLyrics) {
        this.explicitLyrics = explicitLyrics;
    }

    public Integer getExplicitContentLyrics() {
        return explicitContentLyrics;
    }

    public void setExplicitContentLyrics(Integer explicitContentLyrics) {
        this.explicitContentLyrics = explicitContentLyrics;
    }

    public Integer getExplicitContentCover() {
        return explicitContentCover;
    }

    public void setExplicitContentCover(Integer explicitContentCover) {
        this.explicitContentCover = explicitContentCover;
    }

    public List<Contributor> getContributors() {
        return contributors;
    }

    public void setContributors(List<Contributor> contributors) {
        this.contributors = contributors;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Tracks getTracks() {
        return tracks;
    }

    public void setTracks(Tracks tracks) {
        this.tracks = tracks;
    }

    public String getDetails(){
        return String.format(Locale.ENGLISH, "%d tracks, release date: %s", getNbTracks(), getReleaseDate());
    }

}

