package com.m6code.driza.ui.artist;


import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.m6code.driza.datasource.UserSearch;
import com.m6code.driza.model.SearchResponse;
import com.m6code.driza.services.ApiServiceBuilder;
import com.m6code.driza.services.DeezerApiQueryService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtistViewModel extends ViewModel {

    private static final String LOG_TAG = "ArtistViewModel";

    private MutableLiveData<SearchResponse> responseData;

    public ArtistViewModel() {
        responseData = new MutableLiveData<>();
        DeezerApiQueryService artistQueryService = ApiServiceBuilder.buildApiService(DeezerApiQueryService.class);
        Call<SearchResponse> artistQuery = artistQueryService.searchApi("artist", UserSearch.getSearchText(), 500);
        artistQuery.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(@NonNull Call<SearchResponse> call, @NonNull Response<SearchResponse> response) {
                if (response.isSuccessful()) {
                    responseData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<SearchResponse> call, @NonNull Throwable t) {
                Log.e(LOG_TAG, "Request Failed : " + t.getMessage());
            }
        });
    }

    public MutableLiveData<SearchResponse> getResponseData() {
        return responseData;
    }
}
