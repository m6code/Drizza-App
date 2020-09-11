package com.m6code.driza.ui.album;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.m6code.driza.datasource.UserSearch;
import com.m6code.driza.model.Album;
import com.m6code.driza.model.SearchResponse;
import com.m6code.driza.services.ApiServiceBuilder;
import com.m6code.driza.services.DeezerApiQueryService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumViewModel extends ViewModel {
    private static final String LOG_TAG = "AlbumViewModel";
    private MutableLiveData<SearchResponse> albumsLiveData;

    public AlbumViewModel() {
        albumsLiveData = new MutableLiveData<>();

        DeezerApiQueryService queryAlbumService = ApiServiceBuilder.buildApiService(DeezerApiQueryService.class);
        // Do not make Api call if string is empty
        if (!UserSearch.getSearchText().trim().isEmpty()) {
            Call<SearchResponse> queryAlbum = queryAlbumService.searchApi("album", UserSearch.getSearchText(), 500);
            queryAlbum.enqueue(new Callback<SearchResponse>() {
                @Override
                public void onResponse(@NonNull Call<SearchResponse> call, @NonNull Response<SearchResponse> response) {
                    if (response.isSuccessful()) {
                        albumsLiveData.setValue(response.body());
                    }

                }

                @Override
                public void onFailure(@NonNull Call<SearchResponse> call, @NonNull Throwable t) {
                    Log.e(LOG_TAG, "Request Failed : " + t.getMessage());
                }
            });
        }
    }

    public MutableLiveData<SearchResponse> getAlbumsLiveData() {
        return albumsLiveData;
    }
}
