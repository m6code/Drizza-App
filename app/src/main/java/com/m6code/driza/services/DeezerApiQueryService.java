package com.m6code.driza.services;

import com.m6code.driza.model.Album;
import com.m6code.driza.model.SearchResponse;

import java.math.BigInteger;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface DeezerApiQueryService {

    @GET()
    Call<SearchResponse> directApiQuery(@Url String url);

    @GET("search/{type}")
    Call<SearchResponse> searchApi(@Path("type") String searchType, @Query("q") String searchText, @Query("limit") int limitResultTo );

    @GET("{type}/{id}")
    Call<SearchResponse> getDiaFromApi(@Path("type") String type, @Path("id") BigInteger id);
}