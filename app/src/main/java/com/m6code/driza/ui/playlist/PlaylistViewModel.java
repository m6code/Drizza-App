package com.m6code.driza.ui.playlist;

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

public class PlaylistViewModel extends ViewModel {

    private static final String LOG_TAG = "PlaylistViewModel";
    private MutableLiveData<SearchResponse> playlistLiveData;

    public PlaylistViewModel() {
        playlistLiveData = new MutableLiveData<>();

        DeezerApiQueryService playlistQueryService = ApiServiceBuilder.buildApiService(DeezerApiQueryService.class);
        // Do not make Api call if string is empty
        if (!UserSearch.getSearchText().trim().isEmpty()) {
            //Call<SearchResponse> playlistQuery = playlistQueryService.directApiQuery("https://api.deezer.com/search?limit=500&q=playlist:"+UserSearch.getSearchText());
            Call<SearchResponse> playlistQuery = playlistQueryService.searchApi("playlist", UserSearch.getSearchText(), 500);
            playlistQuery.enqueue(new Callback<SearchResponse>() {
                @Override
                public void onResponse(@NonNull Call<SearchResponse> call, @NonNull Response<SearchResponse> response) {
                    if (response.isSuccessful()) {
                        playlistLiveData.setValue(response.body());
                    }

                }

                @Override
                public void onFailure(@NonNull Call<SearchResponse> call, @NonNull Throwable t) {
                    Log.e(LOG_TAG, "Request Failed : " + t.getMessage());
                }
            });
        }
    }

    public MutableLiveData<SearchResponse> getPlaylistLiveData() {
        return playlistLiveData;
    }
}
