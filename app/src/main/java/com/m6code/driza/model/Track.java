package com.m6code.driza.model;

import java.math.BigInteger;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Track {

    @SerializedName("id")
    @Expose
    private BigInteger id;
    @SerializedName("readable")
    @Expose
    private Boolean readable;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("title_short")
    @Expose
    private String titleShort;
    @SerializedName("title_version")
    @Expose
    private String titleVersion;
    @SerializedName("isrc")
    @Expose
    private String isrc;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("share")
    @Expose
    private String share;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("track_position")
    @Expose
    private Integer trackPosition;
    @SerializedName("disk_number")
    @Expose
    private Integer diskNumber;
    @SerializedName("rank")
    @Expose
    private BigInteger rank;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("explicit_lyrics")
    @Expose
    private Boolean explicitLyrics;
    @SerializedName("explicit_content_lyrics")
    @Expose
    private Integer explicitContentLyrics;
    @SerializedName("explicit_content_cover")
    @Expose
    private Integer explicitContentCover;
    @SerializedName("preview")
    @Expose
    private String preview;
    @SerializedName("bpm")
    @Expose
    private Double bpm;
    @SerializedName("gain")
    @Expose
    private Double gain;
    @SerializedName("available_countries")
    @Expose
    private List<String> availableCountries = null;
    @SerializedName("contributors")
    @Expose
    private List<Contributor> contributors = null;
    @SerializedName("md5_image")
    @Expose
    private String md5Image;
    @SerializedName("artist")
    @Expose
    private Artist artist;
    @SerializedName("album")
    @Expose
    private Album album;
    @SerializedName("type")
    @Expose
    private String type;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Boolean getReadable() {
        return readable;
    }

    public void setReadable(Boolean readable) {
        this.readable = readable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleShort() {
        return titleShort;
    }

    public void setTitleShort(String titleShort) {
        this.titleShort = titleShort;
    }

    public String getTitleVersion() {
        return titleVersion;
    }

    public void setTitleVersion(String titleVersion) {
        this.titleVersion = titleVersion;
    }

    public String getIsrc() {
        return isrc;
    }

    public void setIsrc(String isrc) {
        this.isrc = isrc;
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getTrackPosition() {
        return trackPosition;
    }

    public void setTrackPosition(Integer trackPosition) {
        this.trackPosition = trackPosition;
    }

    public Integer getDiskNumber() {
        return diskNumber;
    }

    public void setDiskNumber(Integer diskNumber) {
        this.diskNumber = diskNumber;
    }

    public BigInteger getRank() {
        return rank;
    }

    public void setRank(BigInteger rank) {
        this.rank = rank;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
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

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public Double getBpm() {
        return bpm;
    }

    public void setBpm(Double bpm) {
        this.bpm = bpm;
    }

    public Double getGain() {
        return gain;
    }

    public void setGain(Double gain) {
        this.gain = gain;
    }

    public List<String> getAvailableCountries() {
        return availableCountries;
    }

    public void setAvailableCountries(List<String> availableCountries) {
        this.availableCountries = availableCountries;
    }

    public List<Contributor> getContributors() {
        return contributors;
    }

    public void setContributors(List<Contributor> contributors) {
        this.contributors = contributors;
    }

    public String getMd5Image() {
        return md5Image;
    }

    public void setMd5Image(String md5Image) {
        this.md5Image = md5Image;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}