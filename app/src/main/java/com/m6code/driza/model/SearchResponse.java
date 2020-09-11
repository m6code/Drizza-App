package com.m6code.driza.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResponse {

        @SerializedName("data")
        @Expose
        private List<Datum> data = null;
        @SerializedName("total")
        @Expose
        private Integer total;
        @SerializedName("next")
        @Expose
        private String next;
        @SerializedName("prev")
        @Expose
        private String prev;

        /**
         * No args constructor for use in serialization
         *
         */
        public SearchResponse() {
        }

        /**
         *
         * @param next contains next 25 results
         * @param total total number of results returned from search
         * @param data  data object returned from search
         */
        public SearchResponse(List<Datum> data, Integer total, String next) {
            super();
            this.data = data;
            this.total = total;
            this.next = next;
        }

        public List<Datum> getData() {
            return data;
        }

        public void setData(List<Datum> data) {
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

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }
}
