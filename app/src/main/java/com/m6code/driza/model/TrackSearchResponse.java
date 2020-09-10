package com.m6code.driza.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrackSearchResponse {

        @SerializedName("data")
        @Expose
        private List<TrackSearchResponseData> data = null;
        @SerializedName("total")
        @Expose
        private Integer total;
        @SerializedName("next")
        @Expose
        private String next;

        /**
         * No args constructor for use in serialization
         *
         */
        public TrackSearchResponse() {
        }

        /**
         *
         * @param next contains next 25 tracks
         * @param total total number of tracks returned from search
         * @param data track data returned from search
         */
        public TrackSearchResponse(List<TrackSearchResponseData> data, Integer total, String next) {
            super();
            this.data = data;
            this.total = total;
            this.next = next;
        }

        public List<TrackSearchResponseData> getData() {
            return data;
        }

        public void setData(List<TrackSearchResponseData> data) {
            this.data = data;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }

    }
