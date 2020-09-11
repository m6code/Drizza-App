package com.m6code.driza.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;

public class Creator {

    @SerializedName("id")
    @Expose
    private BigInteger id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("tracklist")
    @Expose
    private String tracklist;
    @SerializedName("type")
    @Expose
    private String type;

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

}