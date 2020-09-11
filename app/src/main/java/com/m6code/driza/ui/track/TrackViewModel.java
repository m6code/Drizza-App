package com.m6code.driza.ui.track;

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

public class TrackViewModel extends ViewModel {

    private static final String LOG_TAG = "TrackViewModel";
    private MutableLiveData<SearchResponse> tracksLiveData;
    //ArrayList<Track> mTracksArrayList;

    public TrackViewModel() {
        tracksLiveData = new MutableLiveData<>();
        // make Api call
        DeezerApiQueryService queryTrackService = ApiServiceBuilder.buildApiService(DeezerApiQueryService.class);

        // todo: use ProgressBar in recyclerView to indicate loading if network availability
        //?index=0&limit=100
        //Call<SearchResponse> queryTracks = queryTrackService.directApiQuery("https://api.deezer.com/search?limit=1000&q=track:\"superhuman\"");
        // Do not make Api call if string is empty
        if (!UserSearch.getSearchText().trim().isEmpty()) {
            Call<SearchResponse> queryTracks = queryTrackService.searchApi("track", UserSearch.getSearchText(), 500);
            queryTracks.enqueue(new Callback<SearchResponse>() {
                @Override
                public void onResponse(@NonNull Call<SearchResponse> call, @NonNull Response<SearchResponse> response) {
                    if (response.isSuccessful()) {
                        tracksLiveData.setValue(response.body());
                    }
                }

                @Override
                public void onFailure(@NonNull Call<SearchResponse> call, @NonNull Throwable t) {
                    Log.e(LOG_TAG, "Request Failed : " + t.getMessage());
                }
            });
        }
    }

    public MutableLiveData<SearchResponse> getTracksLiveData() {
        return tracksLiveData;
    }
}
