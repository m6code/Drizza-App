package com.m6code.driza.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tracks {

    @SerializedName("data")
    @Expose
    private List<TrackDatum> data = null;
    @SerializedName("checksum")
    @Expose
    private String checksum;

    public List<TrackDatum> getData() {
        return data;
    }

    public void setData(List<TrackDatum> data) {
        this.data = data;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

}