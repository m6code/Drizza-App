package com.m6code.driza.ui.track;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.m6code.driza.model.TrackSearchResponse;
import com.m6code.driza.services.ApiServiceBuilder;
import com.m6code.driza.services.DeezerApiQueryService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrackViewModel extends ViewModel {

    private MutableLiveData<TrackSearchResponse> tracksLiveData;
    //ArrayList<Track> mTracksArrayList;

    public TrackViewModel() {
        tracksLiveData = new MutableLiveData<>();
        // make Api call
        DeezerApiQueryService queryTrackService = ApiServiceBuilder.buildApiService(DeezerApiQueryService.class);

        // TODO: Check for internet connectivity before making network call
        // todo: set fallback UI if no network
        // todo: use ProgressBar in recyclerView to indicate loading if network availability
        Call<TrackSearchResponse> queryTracks = queryTrackService.getTrackList("https://api.deezer.com/search?q=track:\"power\"");

        queryTracks.enqueue(new Callback<TrackSearchResponse>() {
            @Override
            public void onResponse(@NonNull Call<TrackSearchResponse> call, @NonNull Response<TrackSearchResponse> response) {
                if (response.isSuccessful()){
                    tracksLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<TrackSearchResponse> call, @NonNull Throwable t) {
                Log.e("Error", "Request Failed : " + t.getMessage() );
            }
        });
    }

    public MutableLiveData<TrackSearchResponse> getTracksLiveData() {
        return tracksLiveData;
    }
}
