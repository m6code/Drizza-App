package com.m6code.driza.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;
import java.util.Locale;

public class Artist {

    @SerializedName("id")
    @Expose
    private BigInteger id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("picture_small")
    @Expose
    private String pictureSmall;
    @SerializedName("picture_medium")
    @Expose
    private String pictureMedium;
    @SerializedName("picture_big")
    @Expose
    private String pictureBig;
    @SerializedName("picture_xl")
    @Expose
    private String pictureXl;
    @SerializedName("nb_album")
    @Expose
    private Integer nbAlbum;
    @SerializedName("nb_fan")
    @Expose
    private BigInteger nbFan;
    @SerializedName("radio")
    @Expose
    private Boolean radio;
    @SerializedName("tracklist")
    @Expose
    private String tracklist;
    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("share")
    @Expose
    private String share;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPictureSmall() {
        return pictureSmall;
    }

    public void setPictureSmall(String pictureSmall) {
        this.pictureSmall = pictureSmall;
    }

    public String getPictureMedium() {
        return pictureMedium;
    }

    public void setPictureMedium(String pictureMedium) {
        this.pictureMedium = pictureMedium;
    }

    public String getPictureBig() {
        return pictureBig;
    }

    public void setPictureBig(String pictureBig) {
        this.pictureBig = pictureBig;
    }

    public String getPictureXl() {
        return pictureXl;
    }

    public void setPictureXl(String pictureXl) {
        this.pictureXl = pictureXl;
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

    public Integer getNbAlbum() {
        return nbAlbum;
    }

    public void setNbAlbum(Integer nbAlbum) {
        this.nbAlbum = nbAlbum;
    }

    public BigInteger getNbFan() {
        return nbFan;
    }

    public void setNbFan(BigInteger nbFan) {
        this.nbFan = nbFan;
    }

    public Boolean getRadio() {
        return radio;
    }

    public void setRadio(Boolean radio) {
        this.radio = radio;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getDetails() {
        //return "Albums(" + getNbAlbum()+") ";
        return String.format(Locale.ENGLISH,"Albums(%d) Fans(%d)", getNbAlbum(), getNbFan());
    }

}
