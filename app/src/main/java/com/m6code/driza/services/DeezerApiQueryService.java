package com.m6code.driza.services;

import com.m6code.driza.model.Album;
import com.m6code.driza.model.TrackSearchResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface DeezerApiQueryService {

    @GET()
    Call<TrackSearchResponse> getTrackList(@Url String url);

    @GET()
    Call<ArrayList<Album>> getAlbumList(@Url String url);
}